pipeline {
    agent {
        docker {
            image 'gradle:7-jdk11'
            reuseNode true
        }
    }
    stages {
        stage ('Checkout') {
            steps {
                checkout scm
                sh 'ls -lat'
            }
        }
        stage("Build") {
            steps {
                sh 'gradle clean build'
                junit "**/build/test-results/test/*.xml"
                jacoco(
                    execPattern: 'build/jacoco/jacoco.exec'
                )
            }
        }
        stage('Publish') {
            environment {
                DOCKERHUB_CREDENTIALS = credentials('dockerhub')
            }
            steps {
                sh "gradle jib"
            }
        }
        stage("Deploy to DEV") {
            environment {
                SSH = "ssh -o StrictHostKeyChecking=no -l deploy dkrsvd01.brulenet.org"
            }
            steps {
                sshagent(credentials: ['jenkins_deploy']) {
                    sh "${SSH} docker run -p 4050:4050 -d --name cellar-ms-java brulejr/cellar-ms-java:latest"
                }
            }
        }
    }
}

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
    }
}

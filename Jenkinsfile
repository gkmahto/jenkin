pipeline {
    agent any

    environment {
        DOCKER_IMAGE = "lsetuk/spring-boot-backend"
        DOCKER_CREDENTIALS_ID = "docker-hub-credentials"
    }

    stages {
        stage('Clone Repository') {
            steps {
                git branch: 'main', url: 'https://github.com/gkmahto/CWBackend.git'
            }
        }

        stage('Build Backend') {
            steps {
                bat './mvnw clean install'
            }
        }

        stage('Build Docker Image') {
            steps {
                bat "docker build -t $DOCKER_IMAGE ."
            }
        }

        stage('Push to Docker Hub') {
            steps {
                withDockerRegistry([credentialsId: DOCKER_CREDENTIALS_ID, url: '']) {
                    bat "docker push $DOCKER_IMAGE"
                }
            }
        }

        stage('Deploy Container') {
            steps {
                bat "docker run -d -p 8080:8080 --name spring-backend $DOCKER_IMAGE"
            }
        }
    }
}
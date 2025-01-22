pipeline {
    agent any
    environment {
        DOCKER_IMAGE = "ketan897654/hrdapplication:latest"
    }
    stages {
        stage('Clone Repository') {
            steps {
                // Clone the repository from source control
                checkout scm
            }
        }
        stage('Build Maven Project') {
            steps {
                // Build the Spring Boot application using Maven
                script {
                    bat 'mvn clean package'
                }
            }
        }
        stage('Build Docker Image') {
            steps {
                // Build a Docker image for the application
                script {
                    bat "docker build -t ${DOCKER_IMAGE} ."
                }
            }
        }
        stage('Push Docker Image') {
            steps {
                // Push the Docker image to Docker Hub
                echo "Inside Docker Image Push Block"
                script {
                    withDockerRegistry([credentialsId: '8f21f922-09cb-4cf6-944e-e353b46fd9f4', url: 'https://index.docker.io/v1/']) {
                        bat "docker push ${DOCKER_IMAGE}"
                    }
                }
            }
        }
        stage('Deploy to Kubernetes') {
            steps {
                // Deploy the application to Kubernetes
                script {
                    bat '''
                    kubectl apply -f k8s-manifests/deployment.yaml
                    '''
                }
            }
        }
    }
    post {
        success {
            // Actions to take on a successful pipeline run
            echo "Pipeline executed successfully!"
        }
        failure {
            // Actions to take if the pipeline fails
            echo "Pipeline failed."
        }
    }
}

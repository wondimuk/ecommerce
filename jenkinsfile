pipeline {
    agent {
        docker {
            image "maven:3.8.3-jdk-15"
            label "docker"
        }
    }
    stages {
        stage("build") {
            steps {
                sh "mvn --version"
                sh "mvn clean install"
            }
        }
    }
    post {
        always {
            cleanWs()
        }
    }
}
pipeline {
    agent any

    environment {
        JAVA_HOME = '/opt/homebrew/opt/openjdk@21'
        PATH = "/opt/homebrew/bin:/opt/homebrew/opt/openjdk@21/bin:${env.PATH}"
    }

    stages {
        stage('Checkout') {
            steps {
                echo 'Checking out source code from GitHub'
                checkout scm
            }
        }

        stage('Verify Tools') {
            steps {
                sh 'which java'
                sh 'java -version'
                sh 'which mvn'
                sh 'mvn -version'
            }
        }

        stage('Build and Test') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Run Application') {
            steps {
                sh 'java -cp target/classes com.example.App'
            }
        }
        stage('Deploy') {
    steps {
        sh 'mkdir -p "$HOME/deployments/jenkins-cicd-demo"'
        sh 'cp target/*.jar "$HOME/deployments/jenkins-cicd-demo/"'
        sh 'ls -lh "$HOME/deployments/jenkins-cicd-demo/"'
    }
}
    }

    post {
    success {
        archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
        echo 'CI Pipeline completed successfully!'
    }
    failure {
        echo 'CI Pipeline failed. Check the console output.'
    }
}
}

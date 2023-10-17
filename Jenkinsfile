pipeline {
    agent any
    tools { 
        jdk 'JDK11'
        maven 'Maven 3.9.2' 
    }
    stages {
        stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                ''' 
            }
        }
        stage('build') {
            steps {
                echo 'Deploy tn_service_registry build automatically #22'
                sh 'mvn --version'

                dir('/var/lib/jenkins/workspace/demo_main') {
                     sh 'mvn clean package -DskipTests'
                }
            }
        }
    }
}

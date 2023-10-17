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
                echo 'Deploy demo jenkins build automatically'
                sh 'mvn --version'

                dir('/var/lib/jenkins/workspace/demojenkins') {
                     sh 'mvn clean package -DskipTests'
                }
            }
        }
    }
}

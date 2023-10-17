pipeline {
    agent any
    tools { 
        jdk 'JDK11'
        maven 'Maven 3.9.2' 
    }
    environment {
        DEPLOYMENT_TIMESTAMP = "${currentBuild.getTimeInMillis()}"
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
                echo 'Build demo jenkins automatically'
                sh 'mvn --version'

                dir('/var/lib/jenkins/workspace/jenkins_demo_main') {
                     sh 'mvn clean package -DskipTests'
                }
            }
        }
        stage('Create Staging Path') {
            steps {
                script {
                    //def stagingPath = "/usr/local/etc/${env.DEPLOYMENT_TIMESTAMP}"
                    def stagingPath = "/usr/local/etc/jenkinsdemo"
                    //sh "mkdir -p ${stagingPath}"
                    sh "cp /var/lib/jenkins/workspace/jenkins_demo_main/target/jenkinsdemo-0.0.1-SNAPSHOT.jar ${stagingPath}"
                    sh 'java -jar ${stagingPath}/jenkinsdemo-0.0.1-SNAPSHOT.jar'
                }
                echo 'Deploy demo jenkins automatically #'
            }
        }
    }
}

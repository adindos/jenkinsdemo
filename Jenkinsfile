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
        stage('deploy') {
            steps {
                script {
                    //def deploymentPath = "/usr/local/etc/${env.DEPLOYMENT_TIMESTAMP}"
                    def deploymentPath = "/usr/local/etc/jenkinsdemo"
                    def jarFilename = "jenkinsdemo-0.0.1-SNAPSHOT.jar"
                    //sh "mkdir -p ${stagingPath}"
                         sh "cp /var/lib/jenkins/workspace/jenkins_demo_main/target/${jarFilename} ${deploymentPath}"
                         sh 'pwd'
                             dir('/usr/local/etc/jenkinsdemo') {
                                 sh "java -jar ${jarFilename}&"
                                 sh "disown -h"
                             }
                         echo 'Deploy demo jenkins automatically '
                }
            }
            post {
                success {
                // This block runs if the entire pipeline is successful
                echo 'Deployment was successful!'
                // You can add more post-deployment steps or notifications here
                }
        
                failure {
                // This block runs if the pipeline fails
                echo 'Deployment failed!'
                // You can add actions for failure scenarios here
                }
            }
        }
    }
 
}

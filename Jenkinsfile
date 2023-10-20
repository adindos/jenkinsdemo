pipeline {
    agent any
    tools { 
        jdk 'JDK11'
        maven 'Maven 3.9.2' 
    }
//     environment {
//         DEPLOYMENT_TIMESTAMP = "${currentBuild.getTimeInMillis()}"
//     }
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
                echo 'Build demo jenkins automatically - here is mvn'
                sh 'mvn --version'
                dir('/var/lib/jenkins/workspace/jenkins_demo_main') {
                     sh 'mvn clean package -DskipTests'
                }
//                 dir('/Users/faizal/.jenkins/workspace/jenkinsdemo_main') {
//                      sh 'mvn clean package -DskipTests'
//                 }
            }
        }
        stage('deploy') {
            steps {
                script {
                    //def deploymentPath = "/usr/local/etc/${env.DEPLOYMENT_TIMESTAMP}"
                    def deploymentPath = "/usr/local/etc/jenkinsdemo"
                    def jarFilename = "jenkinsdemo-0.0.1-SNAPSHOT.jar"
                    //sh "mkdir -p ${stagingPath}"
                        sh "rm ${deploymentPath}/jenkinsdemo-0.0.1-SNAPSHOT.jar"
                        sleep(5)
                        sh "cp /var/lib/jenkins/workspace/jenkins_demo_main/target/${jarFilename} ${deploymentPath}"
//                         sh "cp /Users/faizal/.jenkins/workspace/jenkinsdemo_main/target/${jarFilename} ${deploymentPath}"
                        echo 'transfer jar file to deployment folder '
                }
            }
        }

    stage('execute') {
            steps {
                script {
                    //def deploymentPath = "/usr/local/etc/${env.DEPLOYMENT_TIMESTAMP}"
//                     def deploymentPath = "/usr/local/etc/jenkinsdemo"
//                     def jarFilename = "jenkinsdemo-0.0.1-SNAPSHOT.jar"

//                              dir('/usr/local/etc/jenkinsdemo') {
//                                  sh "./jenkinsdemo.sh"
//                                  exit 130
//                              }

                             //sh "/usr/local/etc/jenkinsdemo/jenkinsdemo.sh"

                         echo 'Deploy demo jenkins automatically - copy to path 5'
                        //exit 130
                }
            }
//             post {
//                 success {
//                 // This block runs if the entire pipeline is successful
//                 echo 'Deployment was successful!'
//                 // You can add more post-deployment steps or notifications here
//                 }
//
//                 failure {
//                 // This block runs if the pipeline fails
//                 echo 'Deployment failed!'
//                 // You can add actions for failure scenarios here ..
//                 }
//             }
        }

        
    }
 
}

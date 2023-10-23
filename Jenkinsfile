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
                echo 'Build demo jenkins automatically - here is mvn again'
                sh 'mvn --version'
                dir('/root/.jenkins/workspace/Jenkins_Demo_main') {
                     sh 'mvn clean package -DskipTests'
                }
//                 dir('/Users/faizal/.jenkins/workspace/jenkinsdemo_main') {
//                      sh 'mvn clean package -DskipTests'
//                 }
            }
        }
        stage('copy') {
                    steps {
                        script {
                             //def deploymentPath = "/usr/local/etc/jenkinsdemo"
                             def sourcePath = "/root/.jenkins/workspace/Jenkins_Demo_main"
                             def deploymentPath = "/usr/local/share/jenkinsdemodepl"
                             def jarFilename = "jenkinsdemo-0.0.1-SNAPSHOT.jar"
                             sh "cp ${sourcePath}/target/${jarFilename} ${deploymentPath}"

        //                         sh "rm ${deploymentPath}/jenkinsdemo-0.0.1-SNAPSHOT.jar"
        //                         sleep(5)
        //                         sh "cp /var/lib/jenkins/workspace/jenkins_demo_main/target/${jarFilename} ${deploymentPath}"
        // //                         sh "cp /Users/faizal/.jenkins/workspace/jenkinsdemo_main/target/${jarFilename} ${deploymentPath}"
        //                         echo 'transfer jar file to deployment folder '
                        }
                    }
        }
        stage('execute') {
                            steps {
                                script {
                                    sh "systemctl stop jenkinsdemo"

                                    sh "systemctl start jenkinsdemo"

                                    sh "systemctl enable jenkinsdemo"
                                }
                            }
        }

    }

}

def call(String Project,String ImageTag,String dockerHubUser){
  withCredentials([usernamePassword('credentialsId':"dockerHub-cred",passwordVariable:"dockerHubPass",usernameVariable:"dockerHubUser")]){
    sh "docker login -u ${dockerHubUser} -p ${dockerHubPass}"
  }
  sh "docker push ${dockerHubUser}/${project}:${ImageTag}"
}

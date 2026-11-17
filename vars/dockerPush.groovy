def call(String projectName, String imageTag = 'latest', String credentialsId = 'DockerCredentials') {
    def imageName = projectName.toLowerCase()
    echo "Pushing Docker image ${imageName}:${imageTag} to Docker Hub"

    withCredentials([usernamePassword(credentialsId: credentialsId, passwordVariable: 'dockerHubPass', usernameVariable: 'dockerHubUser')]) {
        sh 'echo "$dockerHubPass" | docker login -u "$dockerHubUser" --password-stdin'
        sh "docker image tag ${imageName}:${imageTag} ${env.dockerHubUser}/${imageName}:${imageTag}"
        sh "docker push ${env.dockerHubUser}/${imageName}:${imageTag}"
    }

    echo "Docker image pushed successfully"
}

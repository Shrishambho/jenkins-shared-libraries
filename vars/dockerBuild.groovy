def call(String imageName, String imageTag = 'latest', String dockerfilePath = '.') {
    echo "This is building the Docker image: ${imageName}:${imageTag}"
    sh "docker build -t ${imageName}:${imageTag} ${dockerfilePath}"
    echo "Docker image built successfully: ${imageName}:${imageTag}"
}


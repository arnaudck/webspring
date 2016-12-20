node {
	withEnv(["PATH+MVN=${tool 'MVN'}/bin"]) {
		sh 'cd webspring'
		sh 'mvn verify'
	}
}


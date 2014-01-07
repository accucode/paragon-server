This README contains information regarding Amazon Web Service (AWS) deployment.

Installing and configuring Toolkit

    Install AWS CLI 
        1.  Download link (http://aws.amazon.com/cli/)
        2.  Unzip into c:\java\IAMCli

    Create AWS credentials
        1.  Create a new user in the and download the credentials CSV file
	2.  Create a new (C:\java\AWSCLI\aws-credentials.txt)

	Format:
            AWSAccessKeyId=<ACCESS KEY>
            AWSSecretKey=<SECRET KEY>

	3.  Modify _kmSetEnvLocal.bat
		set aws_credential_file=C:\java\AWSCLI\aws-credentials.txt
		set awscli_home=C:\java\AWSCLI
	4.  Run the ImportSettings target of the Setup ANT script.

Deploying software to AWS
    The following scripts are used to manage the AWS environment
	[project_home]/ant/Production
	[project_home]/ant/Test
	[project_home]/ant/Development

    1.  Perform all pre-deployment steps. e.g. Tagging, updating build number
    2.  Run the makeWarUsingTemp target to create the war file in [project_home]/temp
    3.  Run the deploy target to push the war file into the AWS environment.

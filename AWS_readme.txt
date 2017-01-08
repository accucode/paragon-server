This README contains information regarding Amazon Web Service (AWS) deployment.

Installing and configuring Toolkit

    Install AWS CLI
     
        1.  Download and install the MSI setup tool
                http://aws.amazon.com/cli/
        
        2.  We suggest changing the install location to the following...
            Regardless, remember the install location because it must match below.
                c:\java\awscli
                
    Configuring AWS CLI permissions
        1.  In cmd shell, go to the directory where the AWS Cli is installed.
        2.  Run, aws configure --profile core
                Access key ID from credentials file
                Secret Access key from credentials file
                Default region name is us-east-1
                Default output format, just hit enter to accept the default.
        3.  Add env var to developer version of the setEnvLocal file
                set awscli_home=C:\java\awscli    

 [end]
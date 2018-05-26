Amazon Web Services (AWS)
=============================

# Purpose
The purpose of this document is to provide background and instructions
for connecting to AWS.


# Background
Our production environment is hosted using Amazon Web Services (AWS).
AWS configuration is generally NOT necessary for normal development,
but it is required in order to deploy updates.


# Install the AWS CLI
Install the Command Line Interface (CLI).

1. Download the MSI setup tool.

    http://aws.amazon.com/cli/

2. Install it at this location

    c:\tools\awscli


# Configure Permissions
1. Request AWS credentials from your team leader.

2. In cmd shell, go to the directory where the AWS Cli is installed.

3. Run, aws configure --profile core

    Access key ID from credentials file
    Secret Access key from credentials file
    Default region name is us-east-1
    Default output format, just hit enter to accept the default.

4. Add env var to developer version of the kmSetEnvLocal file

    set awscli_home=C:\tools\awscli


# [end]
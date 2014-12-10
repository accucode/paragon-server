/*
  Copyright (c) 2005-2014 www.kodemore.com

  Permission is hereby granted, free of charge, to any person obtaining a copy
  of this software and associated documentation files (the "Software"), to deal
  in the Software without restriction, including without limitation the rights
  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
  copies of the Software, and to permit persons to whom the Software is
  furnished to do so, subject to the following conditions:

  The above copyright notice and this permission notice shall be included in
  all copies or substantial portions of the Software.

  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
  THE SOFTWARE.
*/

package com.kodemore.aws.s3;

import java.io.File;
import java.io.IOException;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;

import com.kodemore.utility.Kmu;

public class KmS3Uploader
{

    //##################################################
    //# variables
    //##################################################

    private String _accessKeyId;
    private String _secretKey;

    //##################################################
    //# accessing
    //##################################################

    public String getAccessKeyId()
    {
        return _accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId)
    {
        _accessKeyId = accessKeyId;
    }

    public String getSecretKey()
    {
        return _secretKey;
    }

    public void setSecretKey(String secretKey)
    {
        _secretKey = secretKey;
    }

    //##################################################
    //# public
    //##################################################

    public void upload(String bucketName, String filePath, String data)
    {
        File f = writeToTemp(data);
        upload(bucketName, filePath, f);
        f.delete();
    }

    public void upload(String bucketName, String filePath, File f)
    {
        //filePath should not begin with a '/'

        AmazonS3 conn = createS3Client();
        conn.putObject(bucketName, filePath, f);
    }

    //##################################################
    //# private
    //##################################################

    private File writeToTemp(String data)
    {
        File temp = null;

        try
        {
            temp = File.createTempFile("temp", ".tmp");
            Kmu.writeFile(temp, data);
        }
        catch ( IOException ex )
        {
            ex.printStackTrace();
            Kmu.toRuntime(ex);
        }

        return temp;
    }

    private AmazonS3Client createS3Client()
    {
        AWSCredentials credentials = new BasicAWSCredentials(_accessKeyId, _secretKey);
        return new AmazonS3Client(credentials);
    }

    //##################################################
    //# main
    //##################################################

    public static void main(String[] args)
    {

        KmS3Uploader e = new KmS3Uploader();
        e.setAccessKeyId("{replace with IAM ACCESS ID}");
        e.setSecretKey("{replace with SECRET KEY}");

        File f = new File("{replace with filepath}");

        System.out.println("Starting upload.");
        e.upload("{replace with bucketName}", "{replace with filePath}", f);

        System.out.println("File written successfully to S3!");

    }

}

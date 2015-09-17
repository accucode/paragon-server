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
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.util.StringInputStream;

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

    /**
     * Upload the string to the remote s3 repository.
     * The toPath (at s3) should NOT begin with a slash (/).
     */
    public void upload(String bucketName, String toPath, String fromSource)
    {
        StringInputStream is = null;
        try
        {
            is = new StringInputStream(fromSource);
            upload(bucketName, toPath, is);
        }
        catch ( UnsupportedEncodingException ex )
        {
            Kmu.closeSafely(is);
        }
    }

    /**
     * Upload the data from the input stream to the remote s3 repository.
     * The toPath (at s3) should NOT begin with a slash (/).
     */
    public void upload(String bucketName, String toPath, InputStream is)
    {
        ObjectMetadata meta = new ObjectMetadata();

        AmazonS3 s3;
        s3 = createClient();
        s3.putObject(bucketName, toPath, is, meta);
    }

    /**
     * Upload a file from the local file system to the remote s3 repository.
     * The toPath (at s3) should NOT begin with a slash (/).
     */
    public void upload(String bucketName, String toPath, File fromFile)
    {
        AmazonS3 s3;
        s3 = createClient();
        s3.putObject(bucketName, toPath, fromFile);
    }

    //##################################################
    //# private
    //##################################################

    private AmazonS3Client createClient()
    {
        AWSCredentials creds = new BasicAWSCredentials(_accessKeyId, _secretKey);
        return new AmazonS3Client(creds);
    }

    //##################################################
    //# main
    //##################################################

    public static void main(String[] args)
    {
        System.out.println("Testing S3 Upload...");

        File f;
        f = new File("{replace with filepath}");

        KmS3Uploader e;
        e = new KmS3Uploader();
        e.setAccessKeyId("{replace with IAM ACCESS ID}");
        e.setSecretKey("{replace with SECRET KEY}");
        e.upload("{replace with bucketName}", "{replace with filePath}", f);

        System.out.println("File written successfully to S3!");
    }

}

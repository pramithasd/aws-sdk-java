/*
 * Copyright 2012-2017 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file except in compliance with
 * the License. A copy of the License is located at
 * 
 * http://aws.amazon.com/apache2.0
 * 
 * or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */
package com.amazonaws.services.lightsail.model;

import java.io.Serializable;
import javax.annotation.Generated;

import com.amazonaws.AmazonWebServiceRequest;

/**
 * 
 * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/lightsail-2016-11-28/GetDomains" target="_top">AWS API
 *      Documentation</a>
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class GetDomainsRequest extends com.amazonaws.AmazonWebServiceRequest implements Serializable, Cloneable {

    /**
     * <p>
     * A token used for advancing to the next page of results from your get domains request.
     * </p>
     */
    private String pageToken;

    /**
     * <p>
     * A token used for advancing to the next page of results from your get domains request.
     * </p>
     * 
     * @param pageToken
     *        A token used for advancing to the next page of results from your get domains request.
     */

    public void setPageToken(String pageToken) {
        this.pageToken = pageToken;
    }

    /**
     * <p>
     * A token used for advancing to the next page of results from your get domains request.
     * </p>
     * 
     * @return A token used for advancing to the next page of results from your get domains request.
     */

    public String getPageToken() {
        return this.pageToken;
    }

    /**
     * <p>
     * A token used for advancing to the next page of results from your get domains request.
     * </p>
     * 
     * @param pageToken
     *        A token used for advancing to the next page of results from your get domains request.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public GetDomainsRequest withPageToken(String pageToken) {
        setPageToken(pageToken);
        return this;
    }

    /**
     * Returns a string representation of this object; useful for testing and debugging.
     *
     * @return A string representation of this object.
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getPageToken() != null)
            sb.append("PageToken: ").append(getPageToken());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof GetDomainsRequest == false)
            return false;
        GetDomainsRequest other = (GetDomainsRequest) obj;
        if (other.getPageToken() == null ^ this.getPageToken() == null)
            return false;
        if (other.getPageToken() != null && other.getPageToken().equals(this.getPageToken()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getPageToken() == null) ? 0 : getPageToken().hashCode());
        return hashCode;
    }

    @Override
    public GetDomainsRequest clone() {
        return (GetDomainsRequest) super.clone();
    }

}

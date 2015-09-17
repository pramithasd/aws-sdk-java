/*
 * Copyright 2010-2015 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package com.amazonaws.services.logs.model;

import com.amazonaws.AmazonServiceException;

/**
 * 
 */
public class InvalidSequenceTokenException extends AmazonServiceException {
    private static final long serialVersionUID = 1L;

    private String expectedSequenceToken;

    /**
     * Constructs a new InvalidSequenceTokenException with the specified error
     * message.
     *
     * @param message
     *        Describes the error encountered.
     */
    public InvalidSequenceTokenException(String message) {
        super(message);
    }

    /**
     * Sets the value of the ExpectedSequenceToken property for this object.
     * 
     * @param expectedSequenceToken
     *        The new value for the ExpectedSequenceToken property for this
     *        object.
     */
    public void setExpectedSequenceToken(String expectedSequenceToken) {
        this.expectedSequenceToken = expectedSequenceToken;
    }

    /**
     * Returns the value of the ExpectedSequenceToken property for this object.
     * 
     * @return The value of the ExpectedSequenceToken property for this object.
     */
    public String getExpectedSequenceToken() {
        return this.expectedSequenceToken;
    }

    /**
     * Sets the value of the ExpectedSequenceToken property for this object.
     * 
     * @param expectedSequenceToken
     *        The new value for the ExpectedSequenceToken property for this
     *        object.
     * @return Returns a reference to this object so that method calls can be
     *         chained together.
     */
    public InvalidSequenceTokenException withExpectedSequenceToken(
            String expectedSequenceToken) {
        setExpectedSequenceToken(expectedSequenceToken);
        return this;
    }

}
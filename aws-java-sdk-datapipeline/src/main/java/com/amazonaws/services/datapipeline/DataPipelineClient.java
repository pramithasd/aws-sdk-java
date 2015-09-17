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
package com.amazonaws.services.datapipeline;

import java.net.*;
import java.util.*;

import org.apache.commons.logging.*;

import com.amazonaws.*;
import com.amazonaws.regions.*;
import com.amazonaws.auth.*;
import com.amazonaws.handlers.*;
import com.amazonaws.http.*;
import com.amazonaws.regions.*;
import com.amazonaws.internal.*;
import com.amazonaws.metrics.*;
import com.amazonaws.transform.*;
import com.amazonaws.util.*;
import com.amazonaws.util.AWSRequestMetrics.Field;
import com.amazonaws.util.json.*;

import com.amazonaws.services.datapipeline.model.*;
import com.amazonaws.services.datapipeline.model.transform.*;

/**
 * Client for accessing DataPipeline.  All service calls made
 * using this client are blocking, and will not return until the service call
 * completes.
 * <p>
 * <p>
 * AWS Data Pipeline configures and manages a data-driven workflow called
 * a pipeline. AWS Data Pipeline handles the details of scheduling and
 * ensuring that data dependencies are met so that your application can
 * focus on processing the data.
 * </p>
 * <p>
 * AWS Data Pipeline provides a JAR implementation of a task runner
 * called AWS Data Pipeline Task Runner. AWS Data Pipeline Task Runner
 * provides logic for common data management scenarios, such as
 * performing database queries and running data analysis using Amazon
 * Elastic MapReduce (Amazon EMR). You can use AWS Data Pipeline Task
 * Runner as your task runner, or you can write your own task runner to
 * provide custom data management.
 * </p>
 * <p>
 * AWS Data Pipeline implements two main sets of functionality. Use the
 * first set to create a pipeline and define data sources, schedules,
 * dependencies, and the transforms to be performed on the data. Use the
 * second set in your task runner application to receive the next task
 * ready for processing. The logic for performing the task, such as
 * querying the data, running data analysis, or converting the data from
 * one format to another, is contained within the task runner. The task
 * runner performs the task assigned to it by the web service, reporting
 * progress to the web service as it does so. When the task is done, the
 * task runner reports the final success or failure of the task to the
 * web service.
 * </p>
 */
public class DataPipelineClient extends AmazonWebServiceClient implements DataPipeline {

    /** Provider for AWS credentials. */
    private AWSCredentialsProvider awsCredentialsProvider;

    private static final Log log = LogFactory.getLog(DataPipeline.class);

    /**
     * List of exception unmarshallers for all DataPipeline exceptions.
     */
    protected List<JsonErrorUnmarshaller> jsonErrorUnmarshallers;

    /**
     * Constructs a new client to invoke service methods on
     * DataPipeline.  A credentials provider chain will be used
     * that searches for credentials in this order:
     * <ul>
     *  <li> Environment Variables - AWS_ACCESS_KEY_ID and AWS_SECRET_KEY </li>
     *  <li> Java System Properties - aws.accessKeyId and aws.secretKey </li>
     *  <li> Instance profile credentials delivered through the Amazon EC2 metadata service </li>
     * </ul>
     *
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @see DefaultAWSCredentialsProviderChain
     */
    public DataPipelineClient() {
        this(new DefaultAWSCredentialsProviderChain(), new ClientConfiguration());
    }

    /**
     * Constructs a new client to invoke service methods on
     * DataPipeline.  A credentials provider chain will be used
     * that searches for credentials in this order:
     * <ul>
     *  <li> Environment Variables - AWS_ACCESS_KEY_ID and AWS_SECRET_KEY </li>
     *  <li> Java System Properties - aws.accessKeyId and aws.secretKey </li>
     *  <li> Instance profile credentials delivered through the Amazon EC2 metadata service </li>
     * </ul>
     *
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @param clientConfiguration The client configuration options controlling how this
     *                       client connects to DataPipeline
     *                       (ex: proxy settings, retry counts, etc.).
     *
     * @see DefaultAWSCredentialsProviderChain
     */
    public DataPipelineClient(ClientConfiguration clientConfiguration) {
        this(new DefaultAWSCredentialsProviderChain(), clientConfiguration);
    }

    /**
     * Constructs a new client to invoke service methods on
     * DataPipeline using the specified AWS account credentials.
     * 
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @param awsCredentials The AWS credentials (access key ID and secret key) to use
     *                       when authenticating with AWS services.
     */
    public DataPipelineClient(AWSCredentials awsCredentials) {
        this(awsCredentials, new ClientConfiguration());
    }

    /**
     * Constructs a new client to invoke service methods on
     * DataPipeline using the specified AWS account credentials
     * and client configuration options.
     * 
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @param awsCredentials The AWS credentials (access key ID and secret key) to use
     *                       when authenticating with AWS services.
     * @param clientConfiguration The client configuration options controlling how this
     *                       client connects to DataPipeline
     *                       (ex: proxy settings, retry counts, etc.).
     */
    public DataPipelineClient(AWSCredentials awsCredentials, ClientConfiguration clientConfiguration) {
        super(adjustClientConfiguration(clientConfiguration));
        
        this.awsCredentialsProvider = new StaticCredentialsProvider(awsCredentials);
        
        init();
    }

    /**
     * Constructs a new client to invoke service methods on
     * DataPipeline using the specified AWS account credentials provider.
     * 
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @param awsCredentialsProvider
     *            The AWS credentials provider which will provide credentials
     *            to authenticate requests with AWS services.
     */
    public DataPipelineClient(AWSCredentialsProvider awsCredentialsProvider) {
        this(awsCredentialsProvider, new ClientConfiguration());
    }

    /**
     * Constructs a new client to invoke service methods on
     * DataPipeline using the specified AWS account credentials
     * provider and client configuration options.
     * 
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @param awsCredentialsProvider
     *            The AWS credentials provider which will provide credentials
     *            to authenticate requests with AWS services.
     * @param clientConfiguration The client configuration options controlling how this
     *                       client connects to DataPipeline
     *                       (ex: proxy settings, retry counts, etc.).
     */
    public DataPipelineClient(AWSCredentialsProvider awsCredentialsProvider, ClientConfiguration clientConfiguration) {
        this(awsCredentialsProvider, clientConfiguration, null);
    }

    /**
     * Constructs a new client to invoke service methods on
     * DataPipeline using the specified AWS account credentials
     * provider, client configuration options and request metric collector.
     * 
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @param awsCredentialsProvider
     *            The AWS credentials provider which will provide credentials
     *            to authenticate requests with AWS services.
     * @param clientConfiguration The client configuration options controlling how this
     *                       client connects to DataPipeline
     *                       (ex: proxy settings, retry counts, etc.).
     * @param requestMetricCollector optional request metric collector
     */
    public DataPipelineClient(AWSCredentialsProvider awsCredentialsProvider,
            ClientConfiguration clientConfiguration,
            RequestMetricCollector requestMetricCollector) {
        super(adjustClientConfiguration(clientConfiguration), requestMetricCollector);
        
        this.awsCredentialsProvider = awsCredentialsProvider;
        
        init();
    }

    private void init() {
        jsonErrorUnmarshallers = new ArrayList<JsonErrorUnmarshaller>();
        jsonErrorUnmarshallers.add(new PipelineNotFoundExceptionUnmarshaller());
        jsonErrorUnmarshallers.add(new InternalServiceErrorExceptionUnmarshaller());
        jsonErrorUnmarshallers.add(new TaskNotFoundExceptionUnmarshaller());
        jsonErrorUnmarshallers.add(new PipelineDeletedExceptionUnmarshaller());
        jsonErrorUnmarshallers.add(new InvalidRequestExceptionUnmarshaller());
        
        jsonErrorUnmarshallers.add(new JsonErrorUnmarshaller());
        
        // calling this.setEndPoint(...) will also modify the signer accordingly
        this.setEndpoint("datapipeline.us-east-1.amazonaws.com");
        
        HandlerChainFactory chainFactory = new HandlerChainFactory();
        requestHandler2s.addAll(chainFactory.newRequestHandlerChain(
                "/com/amazonaws/services/datapipeline/request.handlers"));
        requestHandler2s.addAll(chainFactory.newRequestHandler2Chain(
                "/com/amazonaws/services/datapipeline/request.handler2s"));
    }

    private static ClientConfiguration adjustClientConfiguration(ClientConfiguration orig) {
        ClientConfiguration config = orig;
        
        return config;
    }

    /**
     * <p>
     * Validates the specified pipeline and starts processing pipeline
     * tasks. If the pipeline does not pass validation, activation fails.
     * </p>
     * <p>
     * If you need to pause the pipeline to investigate an issue with a
     * component, such as a data source or script, call DeactivatePipeline.
     * </p>
     * <p>
     * To activate a finished pipeline, modify the end date for the pipeline
     * and then activate it.
     * </p>
     *
     * @param activatePipelineRequest Container for the necessary parameters
     *           to execute the ActivatePipeline service method on DataPipeline.
     * 
     * @return The response from the ActivatePipeline service method, as
     *         returned by DataPipeline.
     * 
     * @throws PipelineNotFoundException
     * @throws InternalServiceErrorException
     * @throws InvalidRequestException
     * @throws PipelineDeletedException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by DataPipeline indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public ActivatePipelineResult activatePipeline(ActivatePipelineRequest activatePipelineRequest) {
        ExecutionContext executionContext = createExecutionContext(activatePipelineRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ActivatePipelineRequest> request = null;
        Response<ActivatePipelineResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ActivatePipelineRequestMarshaller().marshall(super.beforeMarshalling(activatePipelineRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            Unmarshaller<ActivatePipelineResult, JsonUnmarshallerContext> unmarshaller =
                new ActivatePipelineResultJsonUnmarshaller();
            JsonResponseHandler<ActivatePipelineResult> responseHandler =
                new JsonResponseHandler<ActivatePipelineResult>(unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Lists the pipeline identifiers for all active pipelines that you have
     * permission to access.
     * </p>
     *
     * @param listPipelinesRequest Container for the necessary parameters to
     *           execute the ListPipelines service method on DataPipeline.
     * 
     * @return The response from the ListPipelines service method, as
     *         returned by DataPipeline.
     * 
     * @throws InternalServiceErrorException
     * @throws InvalidRequestException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by DataPipeline indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public ListPipelinesResult listPipelines(ListPipelinesRequest listPipelinesRequest) {
        ExecutionContext executionContext = createExecutionContext(listPipelinesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListPipelinesRequest> request = null;
        Response<ListPipelinesResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListPipelinesRequestMarshaller().marshall(super.beforeMarshalling(listPipelinesRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            Unmarshaller<ListPipelinesResult, JsonUnmarshallerContext> unmarshaller =
                new ListPipelinesResultJsonUnmarshaller();
            JsonResponseHandler<ListPipelinesResult> responseHandler =
                new JsonResponseHandler<ListPipelinesResult>(unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Task runners call <code>ReportTaskProgress</code> when assigned a
     * task to acknowledge that it has the task. If the web service does not
     * receive this acknowledgement within 2 minutes, it assigns the task in
     * a subsequent PollForTask call. After this initial acknowledgement, the
     * task runner only needs to report progress every 15 minutes to maintain
     * its ownership of the task. You can change this reporting time from 15
     * minutes by specifying a <code>reportProgressTimeout</code> field in
     * your pipeline.
     * </p>
     * <p>
     * If a task runner does not report its status after 5 minutes, AWS Data
     * Pipeline assumes that the task runner is unable to process the task
     * and reassigns the task in a subsequent response to PollForTask. Task
     * runners should call <code>ReportTaskProgress</code> every 60 seconds.
     * </p>
     *
     * @param reportTaskProgressRequest Container for the necessary
     *           parameters to execute the ReportTaskProgress service method on
     *           DataPipeline.
     * 
     * @return The response from the ReportTaskProgress service method, as
     *         returned by DataPipeline.
     * 
     * @throws PipelineNotFoundException
     * @throws InternalServiceErrorException
     * @throws InvalidRequestException
     * @throws TaskNotFoundException
     * @throws PipelineDeletedException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by DataPipeline indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public ReportTaskProgressResult reportTaskProgress(ReportTaskProgressRequest reportTaskProgressRequest) {
        ExecutionContext executionContext = createExecutionContext(reportTaskProgressRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ReportTaskProgressRequest> request = null;
        Response<ReportTaskProgressResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ReportTaskProgressRequestMarshaller().marshall(super.beforeMarshalling(reportTaskProgressRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            Unmarshaller<ReportTaskProgressResult, JsonUnmarshallerContext> unmarshaller =
                new ReportTaskProgressResultJsonUnmarshaller();
            JsonResponseHandler<ReportTaskProgressResult> responseHandler =
                new JsonResponseHandler<ReportTaskProgressResult>(unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Task runners call <code>PollForTask</code> to receive a task to
     * perform from AWS Data Pipeline. The task runner specifies which tasks
     * it can perform by setting a value for the <code>workerGroup</code>
     * parameter. The task returned can come from any of the pipelines that
     * match the <code>workerGroup</code> value passed in by the task runner
     * and that was launched using the IAM user credentials specified by the
     * task runner.
     * </p>
     * <p>
     * If tasks are ready in the work queue, <code>PollForTask</code>
     * returns a response immediately. If no tasks are available in the
     * queue, <code>PollForTask</code> uses long-polling and holds on to a
     * poll connection for up to a 90 seconds, during which time the first
     * newly scheduled task is handed to the task runner. To accomodate this,
     * set the socket timeout in your task runner to 90 seconds. The task
     * runner should not call <code>PollForTask</code> again on the same
     * <code>workerGroup</code> until it receives a response, and this can
     * take up to 90 seconds.
     * </p>
     *
     * @param pollForTaskRequest Container for the necessary parameters to
     *           execute the PollForTask service method on DataPipeline.
     * 
     * @return The response from the PollForTask service method, as returned
     *         by DataPipeline.
     * 
     * @throws InternalServiceErrorException
     * @throws InvalidRequestException
     * @throws TaskNotFoundException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by DataPipeline indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public PollForTaskResult pollForTask(PollForTaskRequest pollForTaskRequest) {
        ExecutionContext executionContext = createExecutionContext(pollForTaskRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<PollForTaskRequest> request = null;
        Response<PollForTaskResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new PollForTaskRequestMarshaller().marshall(super.beforeMarshalling(pollForTaskRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            Unmarshaller<PollForTaskResult, JsonUnmarshallerContext> unmarshaller =
                new PollForTaskResultJsonUnmarshaller();
            JsonResponseHandler<PollForTaskResult> responseHandler =
                new JsonResponseHandler<PollForTaskResult>(unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Validates the specified pipeline definition to ensure that it is well
     * formed and can be run without error.
     * </p>
     *
     * @param validatePipelineDefinitionRequest Container for the necessary
     *           parameters to execute the ValidatePipelineDefinition service method on
     *           DataPipeline.
     * 
     * @return The response from the ValidatePipelineDefinition service
     *         method, as returned by DataPipeline.
     * 
     * @throws PipelineNotFoundException
     * @throws InternalServiceErrorException
     * @throws InvalidRequestException
     * @throws PipelineDeletedException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by DataPipeline indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public ValidatePipelineDefinitionResult validatePipelineDefinition(ValidatePipelineDefinitionRequest validatePipelineDefinitionRequest) {
        ExecutionContext executionContext = createExecutionContext(validatePipelineDefinitionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ValidatePipelineDefinitionRequest> request = null;
        Response<ValidatePipelineDefinitionResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ValidatePipelineDefinitionRequestMarshaller().marshall(super.beforeMarshalling(validatePipelineDefinitionRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            Unmarshaller<ValidatePipelineDefinitionResult, JsonUnmarshallerContext> unmarshaller =
                new ValidatePipelineDefinitionResultJsonUnmarshaller();
            JsonResponseHandler<ValidatePipelineDefinitionResult> responseHandler =
                new JsonResponseHandler<ValidatePipelineDefinitionResult>(unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Queries the specified pipeline for the names of objects that match
     * the specified set of conditions.
     * </p>
     *
     * @param queryObjectsRequest Container for the necessary parameters to
     *           execute the QueryObjects service method on DataPipeline.
     * 
     * @return The response from the QueryObjects service method, as returned
     *         by DataPipeline.
     * 
     * @throws PipelineNotFoundException
     * @throws InternalServiceErrorException
     * @throws InvalidRequestException
     * @throws PipelineDeletedException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by DataPipeline indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public QueryObjectsResult queryObjects(QueryObjectsRequest queryObjectsRequest) {
        ExecutionContext executionContext = createExecutionContext(queryObjectsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<QueryObjectsRequest> request = null;
        Response<QueryObjectsResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new QueryObjectsRequestMarshaller().marshall(super.beforeMarshalling(queryObjectsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            Unmarshaller<QueryObjectsResult, JsonUnmarshallerContext> unmarshaller =
                new QueryObjectsResultJsonUnmarshaller();
            JsonResponseHandler<QueryObjectsResult> responseHandler =
                new JsonResponseHandler<QueryObjectsResult>(unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Requests that the status of the specified physical or logical
     * pipeline objects be updated in the specified pipeline. This update
     * might not occur immediately, but is eventually consistent. The status
     * that can be set depends on the type of object (for example, DataNode
     * or Activity). You cannot perform this operation on
     * <code>FINISHED</code> pipelines and attempting to do so returns
     * <code>InvalidRequestException</code> .
     * </p>
     *
     * @param setStatusRequest Container for the necessary parameters to
     *           execute the SetStatus service method on DataPipeline.
     * 
     * 
     * @throws PipelineNotFoundException
     * @throws InternalServiceErrorException
     * @throws InvalidRequestException
     * @throws PipelineDeletedException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by DataPipeline indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public void setStatus(SetStatusRequest setStatusRequest) {
        ExecutionContext executionContext = createExecutionContext(setStatusRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<SetStatusRequest> request = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new SetStatusRequestMarshaller().marshall(super.beforeMarshalling(setStatusRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            JsonResponseHandler<Void> responseHandler = new JsonResponseHandler<Void>(null);
            invoke(request, responseHandler, executionContext);

        } finally {
            
            endClientExecution(awsRequestMetrics, request, null, LOGGING_AWS_REQUEST_METRIC);
        }
    }
    
    /**
     * <p>
     * Deletes a pipeline, its pipeline definition, and its run history. AWS
     * Data Pipeline attempts to cancel instances associated with the
     * pipeline that are currently being processed by task runners.
     * </p>
     * <p>
     * Deleting a pipeline cannot be undone. You cannot query or restore a
     * deleted pipeline. To temporarily pause a pipeline instead of deleting
     * it, call SetStatus with the status set to <code>PAUSE</code> on
     * individual components. Components that are paused by SetStatus can be
     * resumed.
     * </p>
     *
     * @param deletePipelineRequest Container for the necessary parameters to
     *           execute the DeletePipeline service method on DataPipeline.
     * 
     * 
     * @throws PipelineNotFoundException
     * @throws InternalServiceErrorException
     * @throws InvalidRequestException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by DataPipeline indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public void deletePipeline(DeletePipelineRequest deletePipelineRequest) {
        ExecutionContext executionContext = createExecutionContext(deletePipelineRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeletePipelineRequest> request = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeletePipelineRequestMarshaller().marshall(super.beforeMarshalling(deletePipelineRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            JsonResponseHandler<Void> responseHandler = new JsonResponseHandler<Void>(null);
            invoke(request, responseHandler, executionContext);

        } finally {
            
            endClientExecution(awsRequestMetrics, request, null, LOGGING_AWS_REQUEST_METRIC);
        }
    }
    
    /**
     * <p>
     * Deactivates the specified running pipeline. The pipeline is set to
     * the <code>DEACTIVATING</code> state until the deactivation process
     * completes.
     * </p>
     * <p>
     * To resume a deactivated pipeline, use ActivatePipeline. By default,
     * the pipeline resumes from the last completed execution. Optionally,
     * you can specify the date and time to resume the pipeline.
     * </p>
     *
     * @param deactivatePipelineRequest Container for the necessary
     *           parameters to execute the DeactivatePipeline service method on
     *           DataPipeline.
     * 
     * @return The response from the DeactivatePipeline service method, as
     *         returned by DataPipeline.
     * 
     * @throws PipelineNotFoundException
     * @throws InternalServiceErrorException
     * @throws InvalidRequestException
     * @throws PipelineDeletedException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by DataPipeline indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DeactivatePipelineResult deactivatePipeline(DeactivatePipelineRequest deactivatePipelineRequest) {
        ExecutionContext executionContext = createExecutionContext(deactivatePipelineRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeactivatePipelineRequest> request = null;
        Response<DeactivatePipelineResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeactivatePipelineRequestMarshaller().marshall(super.beforeMarshalling(deactivatePipelineRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            Unmarshaller<DeactivatePipelineResult, JsonUnmarshallerContext> unmarshaller =
                new DeactivatePipelineResultJsonUnmarshaller();
            JsonResponseHandler<DeactivatePipelineResult> responseHandler =
                new JsonResponseHandler<DeactivatePipelineResult>(unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Gets the definition of the specified pipeline. You can call
     * <code>GetPipelineDefinition</code> to retrieve the pipeline definition
     * that you provided using PutPipelineDefinition.
     * </p>
     *
     * @param getPipelineDefinitionRequest Container for the necessary
     *           parameters to execute the GetPipelineDefinition service method on
     *           DataPipeline.
     * 
     * @return The response from the GetPipelineDefinition service method, as
     *         returned by DataPipeline.
     * 
     * @throws PipelineNotFoundException
     * @throws InternalServiceErrorException
     * @throws InvalidRequestException
     * @throws PipelineDeletedException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by DataPipeline indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public GetPipelineDefinitionResult getPipelineDefinition(GetPipelineDefinitionRequest getPipelineDefinitionRequest) {
        ExecutionContext executionContext = createExecutionContext(getPipelineDefinitionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<GetPipelineDefinitionRequest> request = null;
        Response<GetPipelineDefinitionResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new GetPipelineDefinitionRequestMarshaller().marshall(super.beforeMarshalling(getPipelineDefinitionRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            Unmarshaller<GetPipelineDefinitionResult, JsonUnmarshallerContext> unmarshaller =
                new GetPipelineDefinitionResultJsonUnmarshaller();
            JsonResponseHandler<GetPipelineDefinitionResult> responseHandler =
                new JsonResponseHandler<GetPipelineDefinitionResult>(unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Task runners call <code>SetTaskStatus</code> to notify AWS Data
     * Pipeline that a task is completed and provide information about the
     * final status. A task runner makes this call regardless of whether the
     * task was sucessful. A task runner does not need to call
     * <code>SetTaskStatus</code> for tasks that are canceled by the web
     * service during a call to ReportTaskProgress.
     * </p>
     *
     * @param setTaskStatusRequest Container for the necessary parameters to
     *           execute the SetTaskStatus service method on DataPipeline.
     * 
     * @return The response from the SetTaskStatus service method, as
     *         returned by DataPipeline.
     * 
     * @throws PipelineNotFoundException
     * @throws InternalServiceErrorException
     * @throws InvalidRequestException
     * @throws TaskNotFoundException
     * @throws PipelineDeletedException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by DataPipeline indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public SetTaskStatusResult setTaskStatus(SetTaskStatusRequest setTaskStatusRequest) {
        ExecutionContext executionContext = createExecutionContext(setTaskStatusRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<SetTaskStatusRequest> request = null;
        Response<SetTaskStatusResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new SetTaskStatusRequestMarshaller().marshall(super.beforeMarshalling(setTaskStatusRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            Unmarshaller<SetTaskStatusResult, JsonUnmarshallerContext> unmarshaller =
                new SetTaskStatusResultJsonUnmarshaller();
            JsonResponseHandler<SetTaskStatusResult> responseHandler =
                new JsonResponseHandler<SetTaskStatusResult>(unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Retrieves metadata about one or more pipelines. The information
     * retrieved includes the name of the pipeline, the pipeline identifier,
     * its current state, and the user account that owns the pipeline. Using
     * account credentials, you can retrieve metadata about pipelines that
     * you or your IAM users have created. If you are using an IAM user
     * account, you can retrieve metadata about only those pipelines for
     * which you have read permissions.
     * </p>
     * <p>
     * To retrieve the full pipeline definition instead of metadata about
     * the pipeline, call GetPipelineDefinition.
     * </p>
     *
     * @param describePipelinesRequest Container for the necessary parameters
     *           to execute the DescribePipelines service method on DataPipeline.
     * 
     * @return The response from the DescribePipelines service method, as
     *         returned by DataPipeline.
     * 
     * @throws PipelineNotFoundException
     * @throws InternalServiceErrorException
     * @throws InvalidRequestException
     * @throws PipelineDeletedException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by DataPipeline indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribePipelinesResult describePipelines(DescribePipelinesRequest describePipelinesRequest) {
        ExecutionContext executionContext = createExecutionContext(describePipelinesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribePipelinesRequest> request = null;
        Response<DescribePipelinesResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribePipelinesRequestMarshaller().marshall(super.beforeMarshalling(describePipelinesRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            Unmarshaller<DescribePipelinesResult, JsonUnmarshallerContext> unmarshaller =
                new DescribePipelinesResultJsonUnmarshaller();
            JsonResponseHandler<DescribePipelinesResult> responseHandler =
                new JsonResponseHandler<DescribePipelinesResult>(unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Task runners call <code>EvaluateExpression</code> to evaluate a
     * string in the context of the specified object. For example, a task
     * runner can evaluate SQL queries stored in Amazon S3.
     * </p>
     *
     * @param evaluateExpressionRequest Container for the necessary
     *           parameters to execute the EvaluateExpression service method on
     *           DataPipeline.
     * 
     * @return The response from the EvaluateExpression service method, as
     *         returned by DataPipeline.
     * 
     * @throws PipelineNotFoundException
     * @throws InternalServiceErrorException
     * @throws InvalidRequestException
     * @throws TaskNotFoundException
     * @throws PipelineDeletedException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by DataPipeline indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public EvaluateExpressionResult evaluateExpression(EvaluateExpressionRequest evaluateExpressionRequest) {
        ExecutionContext executionContext = createExecutionContext(evaluateExpressionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<EvaluateExpressionRequest> request = null;
        Response<EvaluateExpressionResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new EvaluateExpressionRequestMarshaller().marshall(super.beforeMarshalling(evaluateExpressionRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            Unmarshaller<EvaluateExpressionResult, JsonUnmarshallerContext> unmarshaller =
                new EvaluateExpressionResultJsonUnmarshaller();
            JsonResponseHandler<EvaluateExpressionResult> responseHandler =
                new JsonResponseHandler<EvaluateExpressionResult>(unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Creates a new, empty pipeline. Use PutPipelineDefinition to populate
     * the pipeline.
     * </p>
     *
     * @param createPipelineRequest Container for the necessary parameters to
     *           execute the CreatePipeline service method on DataPipeline.
     * 
     * @return The response from the CreatePipeline service method, as
     *         returned by DataPipeline.
     * 
     * @throws InternalServiceErrorException
     * @throws InvalidRequestException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by DataPipeline indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public CreatePipelineResult createPipeline(CreatePipelineRequest createPipelineRequest) {
        ExecutionContext executionContext = createExecutionContext(createPipelineRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreatePipelineRequest> request = null;
        Response<CreatePipelineResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreatePipelineRequestMarshaller().marshall(super.beforeMarshalling(createPipelineRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            Unmarshaller<CreatePipelineResult, JsonUnmarshallerContext> unmarshaller =
                new CreatePipelineResultJsonUnmarshaller();
            JsonResponseHandler<CreatePipelineResult> responseHandler =
                new JsonResponseHandler<CreatePipelineResult>(unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Gets the object definitions for a set of objects associated with the
     * pipeline. Object definitions are composed of a set of fields that
     * define the properties of the object.
     * </p>
     *
     * @param describeObjectsRequest Container for the necessary parameters
     *           to execute the DescribeObjects service method on DataPipeline.
     * 
     * @return The response from the DescribeObjects service method, as
     *         returned by DataPipeline.
     * 
     * @throws PipelineNotFoundException
     * @throws InternalServiceErrorException
     * @throws InvalidRequestException
     * @throws PipelineDeletedException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by DataPipeline indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeObjectsResult describeObjects(DescribeObjectsRequest describeObjectsRequest) {
        ExecutionContext executionContext = createExecutionContext(describeObjectsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeObjectsRequest> request = null;
        Response<DescribeObjectsResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeObjectsRequestMarshaller().marshall(super.beforeMarshalling(describeObjectsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            Unmarshaller<DescribeObjectsResult, JsonUnmarshallerContext> unmarshaller =
                new DescribeObjectsResultJsonUnmarshaller();
            JsonResponseHandler<DescribeObjectsResult> responseHandler =
                new JsonResponseHandler<DescribeObjectsResult>(unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Removes existing tags from the specified pipeline.
     * </p>
     *
     * @param removeTagsRequest Container for the necessary parameters to
     *           execute the RemoveTags service method on DataPipeline.
     * 
     * @return The response from the RemoveTags service method, as returned
     *         by DataPipeline.
     * 
     * @throws PipelineNotFoundException
     * @throws InternalServiceErrorException
     * @throws InvalidRequestException
     * @throws PipelineDeletedException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by DataPipeline indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public RemoveTagsResult removeTags(RemoveTagsRequest removeTagsRequest) {
        ExecutionContext executionContext = createExecutionContext(removeTagsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<RemoveTagsRequest> request = null;
        Response<RemoveTagsResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new RemoveTagsRequestMarshaller().marshall(super.beforeMarshalling(removeTagsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            Unmarshaller<RemoveTagsResult, JsonUnmarshallerContext> unmarshaller =
                new RemoveTagsResultJsonUnmarshaller();
            JsonResponseHandler<RemoveTagsResult> responseHandler =
                new JsonResponseHandler<RemoveTagsResult>(unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Task runners call <code>ReportTaskRunnerHeartbeat</code> every 15
     * minutes to indicate that they are operational. If the AWS Data
     * Pipeline Task Runner is launched on a resource managed by AWS Data
     * Pipeline, the web service can use this call to detect when the task
     * runner application has failed and restart a new instance.
     * </p>
     *
     * @param reportTaskRunnerHeartbeatRequest Container for the necessary
     *           parameters to execute the ReportTaskRunnerHeartbeat service method on
     *           DataPipeline.
     * 
     * @return The response from the ReportTaskRunnerHeartbeat service
     *         method, as returned by DataPipeline.
     * 
     * @throws InternalServiceErrorException
     * @throws InvalidRequestException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by DataPipeline indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public ReportTaskRunnerHeartbeatResult reportTaskRunnerHeartbeat(ReportTaskRunnerHeartbeatRequest reportTaskRunnerHeartbeatRequest) {
        ExecutionContext executionContext = createExecutionContext(reportTaskRunnerHeartbeatRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ReportTaskRunnerHeartbeatRequest> request = null;
        Response<ReportTaskRunnerHeartbeatResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ReportTaskRunnerHeartbeatRequestMarshaller().marshall(super.beforeMarshalling(reportTaskRunnerHeartbeatRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            Unmarshaller<ReportTaskRunnerHeartbeatResult, JsonUnmarshallerContext> unmarshaller =
                new ReportTaskRunnerHeartbeatResultJsonUnmarshaller();
            JsonResponseHandler<ReportTaskRunnerHeartbeatResult> responseHandler =
                new JsonResponseHandler<ReportTaskRunnerHeartbeatResult>(unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Adds tasks, schedules, and preconditions to the specified pipeline.
     * You can use <code>PutPipelineDefinition</code> to populate a new
     * pipeline.
     * </p>
     * <p>
     * <code>PutPipelineDefinition</code> also validates the configuration
     * as it adds it to the pipeline. Changes to the pipeline are saved
     * unless one of the following three validation errors exists in the
     * pipeline.
     * </p>
     * <ol> <li>An object is missing a name or identifier field.</li>
     * <li>A string or reference field is empty.</li>
     * <li>The number of objects in the pipeline exceeds the maximum allowed
     * objects.</li>
     * <li>The pipeline is in a FINISHED state.</li>
     * </ol> <p>
     * Pipeline object definitions are passed to the
     * <code>PutPipelineDefinition</code> action and returned by the
     * GetPipelineDefinition action.
     * </p>
     *
     * @param putPipelineDefinitionRequest Container for the necessary
     *           parameters to execute the PutPipelineDefinition service method on
     *           DataPipeline.
     * 
     * @return The response from the PutPipelineDefinition service method, as
     *         returned by DataPipeline.
     * 
     * @throws PipelineNotFoundException
     * @throws InternalServiceErrorException
     * @throws InvalidRequestException
     * @throws PipelineDeletedException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by DataPipeline indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public PutPipelineDefinitionResult putPipelineDefinition(PutPipelineDefinitionRequest putPipelineDefinitionRequest) {
        ExecutionContext executionContext = createExecutionContext(putPipelineDefinitionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<PutPipelineDefinitionRequest> request = null;
        Response<PutPipelineDefinitionResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new PutPipelineDefinitionRequestMarshaller().marshall(super.beforeMarshalling(putPipelineDefinitionRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            Unmarshaller<PutPipelineDefinitionResult, JsonUnmarshallerContext> unmarshaller =
                new PutPipelineDefinitionResultJsonUnmarshaller();
            JsonResponseHandler<PutPipelineDefinitionResult> responseHandler =
                new JsonResponseHandler<PutPipelineDefinitionResult>(unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Adds or modifies tags for the specified pipeline.
     * </p>
     *
     * @param addTagsRequest Container for the necessary parameters to
     *           execute the AddTags service method on DataPipeline.
     * 
     * @return The response from the AddTags service method, as returned by
     *         DataPipeline.
     * 
     * @throws PipelineNotFoundException
     * @throws InternalServiceErrorException
     * @throws InvalidRequestException
     * @throws PipelineDeletedException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by DataPipeline indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public AddTagsResult addTags(AddTagsRequest addTagsRequest) {
        ExecutionContext executionContext = createExecutionContext(addTagsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<AddTagsRequest> request = null;
        Response<AddTagsResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new AddTagsRequestMarshaller().marshall(super.beforeMarshalling(addTagsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            Unmarshaller<AddTagsResult, JsonUnmarshallerContext> unmarshaller =
                new AddTagsResultJsonUnmarshaller();
            JsonResponseHandler<AddTagsResult> responseHandler =
                new JsonResponseHandler<AddTagsResult>(unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Lists the pipeline identifiers for all active pipelines that you have
     * permission to access.
     * </p>
     * 
     * @return The response from the ListPipelines service method, as
     *         returned by DataPipeline.
     * 
     * @throws InternalServiceErrorException
     * @throws InvalidRequestException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by DataPipeline indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public ListPipelinesResult listPipelines() throws AmazonServiceException, AmazonClientException {
        return listPipelines(new ListPipelinesRequest());
    }

    @Override
    public void setEndpoint(String endpoint) {
        super.setEndpoint(endpoint);
    }

    @Override
    public void setEndpoint(String endpoint, String serviceName, String regionId) throws IllegalArgumentException {
        super.setEndpoint(endpoint, serviceName, regionId);
    }

    /**
     * Returns additional metadata for a previously executed successful, request, typically used for
     * debugging issues where a service isn't acting as expected.  This data isn't considered part
     * of the result data returned by an operation, so it's available through this separate,
     * diagnostic interface.
     * <p>
     * Response metadata is only cached for a limited period of time, so if you need to access
     * this extra diagnostic information for an executed request, you should use this method
     * to retrieve it as soon as possible after executing the request.
     *
     * @param request
     *            The originally executed request
     *
     * @return The response metadata for the specified request, or null if none
     *         is available.
     */
    public ResponseMetadata getCachedResponseMetadata(AmazonWebServiceRequest request) {
        return client.getResponseMetadataForRequest(request);
    }

    private <X, Y extends AmazonWebServiceRequest> Response<X> invoke(Request<Y> request,
            HttpResponseHandler<AmazonWebServiceResponse<X>> responseHandler,
            ExecutionContext executionContext) {
        request.setEndpoint(endpoint);
        request.setTimeOffset(timeOffset);

        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        AWSCredentials credentials;
        awsRequestMetrics.startEvent(Field.CredentialsRequestTime);
        try {
            credentials = awsCredentialsProvider.getCredentials();
        } finally {
            awsRequestMetrics.endEvent(Field.CredentialsRequestTime);
        }

        AmazonWebServiceRequest originalRequest = request.getOriginalRequest();
        if (originalRequest != null && originalRequest.getRequestCredentials() != null) {
            credentials = originalRequest.getRequestCredentials();
        }

        executionContext.setCredentials(credentials);
        JsonErrorResponseHandler errorResponseHandler = new JsonErrorResponseHandler(jsonErrorUnmarshallers);
        Response<X> result = client.execute(request, responseHandler,
                errorResponseHandler, executionContext);
        return result;
    }
}
        
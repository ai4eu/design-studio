.. ===============LICENSE_START=======================================================
.. Acumos CC-BY-4.0
.. ===================================================================================
.. Copyright (C) 2017-2018 AT&T Intellectual Property & Tech Mahindra. All rights reserved.
.. ===================================================================================
.. This Acumos documentation file is distributed by AT&T and Tech Mahindra
.. under the Creative Commons Attribution 4.0 International License (the "License");
.. you may not use this file except in compliance with the License.
.. You may obtain a copy of the License at
..
.. http://creativecommons.org/licenses/by/4.0
..
.. This file is distributed on an "AS IS" BASIS,
.. WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
.. See the License for the specific language governing permissions and
.. limitations under the License.
.. ===============LICENSE_END=========================================================

===============
Model Ingestion
===============

How to Ingest ML Models in Design Studio
========================================

In order to ingest the onboarded ML Models into the Design Studio, the following steps must be performed:

#) The models along with their Protobuf files must be onboarded via the onboarding functionality, or a Protobuf file was generated when the model was onboarded
#) The Protobuf files should have both the service specification and the message specifications
#) The service specification of the Protobuf file should have the complete operation signature(s) listed in them – such as the:

    #) Type of the operation -- rpc, etc
    #) Name of the operation
    #) Input message name
    #) Output message name

#) Each input and output messages should have their message signatures listed, and each field type should be basic Protobuf data type.

#) After the models have been successfully onboarded, the modeler must login to the Acumos Marketplace Portal in order to classify the uploaded model into one of model categories. Currently four categories are supported in Design Studio: Classification, Prediction, Regression and Other. Along with the models, Design Studio supports Data Transformation Tools and Data Sources also.

#) In order to classify the on boarded model into one of the four categories above, the modeler needs to:

    #) Go to the “My Models” in Market Place
    #) Click on the newly on boarded model
    #) Click on “Manage My Models”
    #) Click on “Publish to Marketplace”
    #) Click on “Model Category”
    #) Select the appropriate model category and the toolkit type
    #) Click Done

#) The model would now appear in the “Models” (left hand side) palette of the Design Studio under the appropriate category. The model is now available to be dragged and dropped in the Design Studio canvas.


Files Generated for Design Studio
=================================

Once the models have been onboarded, the Protobuf files associated with the model is used to generate Protbuf.json and TGIF.json files

Protobuf.json File
^^^^^^^^^^^^^^^^^^

This is an intermediary file used to represent the Protobuf.proto file in JSON format. It is used for the generation of TGIF.json file.

TGIF.json File
^^^^^^^^^^^^^^

The TGIF.json file represents an ML Model in the Design Studio. Every model should have a TGIF.json file associated with it to allow the model to be represented in the Design Studio, dragged and dropped in the Canvas and to allow the model to be composed with another model – based on composition rules (explained next).

The TGIF.json file contains these critical pieces of information:

#)    **Self** – section: This section describes the name and version of the ML model which is displayed on the Design Studio Web UI.
#)    **Services.provides** – section: This section provides a list of services offered by the ML Model. At present only the name of the operation and JSON representation of its input messages is included here. The information provided in Services.provides and Services.calls section is used for determining the composability of a pair of output and input ports of the ML Models.
#)    **Services.calls** – section: This section provides a list of output messages of the services offered by the ML Model. As explained earlier, these output messages are consumed by the services provided by other ML Model(s). The name of the operation (same as provided in Services.provides) and JSON representation of its output messages is included here. The information provided in Services.provides and Services.calls section is used for determining the composability of a pair of output and input ports of the ML Models.
#)    **Artifacts.Uri** – section: This section contains the location of the docker image of the ML Model. This information is used by the Blueprint file to retrieve the docker image of the model in order to deploy it in cloud.

CDUMP.json File
^^^^^^^^^^^^^^^

The CDUMP file represents an composite solution metadata which contains the models input and output information. The CDUMP file having multiple fields such as cname, version, cid, solutionId, ctime, mtime, probeIndicator, nodes, relations, validSolution and revisionId.

BLUEPRINT.json File 
^^^^^^^^^^^^^^^^^^^^

The Blueprint file is generated after the successful validation of composite solution. The Bluepriint file looks like a replica of CDUMP file. The content inside the blueprint file is having name, version, input_ports, nodes, probeIndicator.

#)    **input_ports** - section: The input_ports having container_name and operation_signature. The operation_signature having the operation_name.
#)    **nodes** - section: The Nodes contains container_name, node_type, image, proto_uri, operation_signature_list
#)    **operation_signature_list** - section: This contains operation_signature and connected_to fields. operation_signature is having operation_name, input_message_name and output_message_name. connected_to field contains container_name, operation_signature.
#)    **probeIndicator** - section: The probe Indicator value is true or false for the validated composite solution.



/*-
 * ===============LICENSE_START=======================================================
 * Acumos
 * ===================================================================================
 * Copyright (C) 2017 - 2018 AT&T Intellectual Property & Tech Mahindra. All rights reserved.
 * ===================================================================================
 * This Acumos software file is distributed by AT&T and Tech Mahindra
 * under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 * This file is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ===============LICENSE_END=========================================================
 */

package org.acumos.converter;

public class IntToInt implements Converter {

	public Object convert(Object in) throws ConversionException {
		int result = 0;
		/*if(null != in && (in.getClass().equals(Integer.class))){
			result = (Integer)in;
		} */
		
		/*else if(null != in &&  in.getClass().equals(Float.class)){
			result = (Float)in;
		}*/
		
		try{
			result = (Integer) in;
		} catch(Exception e){
			throw new ConversionException("IntToInt Conversion Error : Invalid input " + in);
		}
		return result;
	}

}

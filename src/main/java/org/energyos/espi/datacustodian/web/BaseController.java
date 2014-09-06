/*
 * Copyright 2013,2014 EnergyOS.org
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package org.energyos.espi.datacustodian.web;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.energyos.espi.common.domain.RetailCustomer;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.ModelAttribute;

public class BaseController {
    @ModelAttribute("currentCustomer")
    public RetailCustomer currentCustomer(Principal principal) {
    	try {
            System.out.printf("BaseController: currentCustomer -- %s\n", (RetailCustomer) ((Authentication)principal).getPrincipal());
            return (RetailCustomer) ((Authentication)principal).getPrincipal();
        	} catch (Exception e) {
        	    System.out.printf("BaseController: currentCustomer -- null\n");
        		return null;
        	}
    }
    
    @ModelAttribute("localDataCustodianURL")
    public String localDataCustodianURL(HttpServletRequest request) {
    	String path = request.getServerName() + ":" + request.getServerPort() + request.getServletContext().getContextPath();
    	return path;  
    }
}

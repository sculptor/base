/*
 * (C) Copyright Factory4Solutions a.s. 2009
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.fornax.cartridges.sculptor.smartclient.server.util;

import java.util.Calendar;

import org.fornax.cartridges.sculptor.smartclient.domain.Users;
import org.fornax.cartridges.sculptor.smartclient.serviceapi.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.userdetails.UserDetails;
import org.springframework.security.userdetails.UserDetailsService;
import org.springframework.security.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class SculptorUserDetailProvider implements UserDetailsService {
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
		SculptorUserDetail retVal=null;
		try {
			Users findUser = usersService.findUser(null, username);
			if (findUser != null) {
				retVal=new SculptorUserDetail(findUser.getUsername()
						, findUser.getPassword()
						, findUser.getRoles()
						, findUser.isEnabled()
						, (Calendar.getInstance()).after(findUser.getExpireAt())
						, findUser.getSelectedLanguage().getValue());
			}
		} catch (UsernameNotFoundException unfe) {
			unfe.printStackTrace();
			throw unfe;
		} catch (DataAccessException dae) {
			dae.printStackTrace();
			throw dae;
		} catch (Throwable th) {
			th.printStackTrace();
			throw new UsernameNotFoundException("Error when resolving user '"+username+"'", th);
		}

		return retVal;
	}

	@Autowired
	private UsersService usersService;
}

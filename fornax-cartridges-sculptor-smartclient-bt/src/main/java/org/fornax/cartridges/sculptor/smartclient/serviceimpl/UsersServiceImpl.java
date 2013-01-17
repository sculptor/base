package org.fornax.cartridges.sculptor.smartclient.serviceimpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.fornax.cartridges.sculptor.framework.domain.PagedResult;
import org.fornax.cartridges.sculptor.framework.domain.PagingParameter;
import org.fornax.cartridges.sculptor.framework.errorhandling.ServiceContext;
import org.fornax.cartridges.sculptor.framework.accessapi.ConditionalCriteria;
import org.fornax.cartridges.sculptor.framework.annotation.GuiHints;
import org.fornax.cartridges.sculptor.framework.annotation.Name;
import org.fornax.cartridges.sculptor.framework.annotation.GuiHints.VisibleOn;
import org.fornax.cartridges.sculptor.smartclient.domain.Users;
import org.fornax.cartridges.sculptor.smartclient.domain.UsersProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Implementation of UsersService.
 */
@Service("usersService")
public class UsersServiceImpl extends UsersServiceImplBase {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public Users save(@Name("ctx") ServiceContext ctx, @Name("entity") Users entity) {
		if (entity.getPassword() != null && entity.getPassword().length() < 30) {
			String encodedPass=passwordEncoder.encodePassword(entity.getPassword(), entity.getUsername());
			entity.setPassword(encodedPass);
		}

		return super.save(ctx, entity);
	}

	@GuiHints(visibleOn=VisibleOn.HIDDEN)
	public Users findUser(@Name("ctx") ServiceContext ctx, @Name("username") String username) {
		HashMap<String, Object> parameters=new HashMap<String, Object>();
		parameters.put("username", username);
		List<Users> users = getUsersRepository().findByQuery("Users.findByUsername", parameters);
		if (users.size() == 1) {
			Users user = users.get(0);
			if (user.getRoles() != null) {
				user.getRoles().size();
			}
			return user;
		}

		return null;
	}

	@Override
	public PagedResult<Users> findAll(@Name("ctx") ServiceContext ctx
			, @Name("pagingParameter") PagingParameter pagingParameter) {
		PagedResult<Users> result; 
		if (ctx.isUserInRole("ROLE_ADMIN")) {
			result = super.findAll(ctx, pagingParameter);
		} else {
			List<Users> listResult= new ArrayList<Users>(1);
			listResult.add(findUser(ctx, ctx.getUserId()));
			result=new PagedResult<Users>(listResult, 0, 1, PagedResult.UNKNOWN, 1, 0);
		}

		for (Users u : result.getValues()) {
			if (u.getRoles() != null) {
				u.getRoles().size();
			}
		}
		return result;
	}

	@Override
	public PagedResult<Users> findByCondition(@Name("ctx") ServiceContext ctx,
			@Name("condition") List<ConditionalCriteria> condition,
			@Name("pagingParameter") PagingParameter pagingParameter) {
		if (!ctx.isUserInRole("ROLE_ADMIN")) {
			condition.add(ConditionalCriteria.equal(UsersProperties.username(), ctx.getUserId()));
		}
		PagedResult<Users> result = super.findByCondition(ctx, condition, pagingParameter);
		for (Users user : result.getValues()) {
			user.getRoles().size();
		}
		return result;
	}

	public void changePasswd(ServiceContext ctx, String newPasswd) {
		Users user = findUser(ctx, ctx.getUserId());
		user.setPassword(passwordEncoder.encodePassword(newPasswd, user.getUsername()));		
		getUsersRepository().save(user);
	}
}

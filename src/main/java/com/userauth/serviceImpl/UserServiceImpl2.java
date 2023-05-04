//package com.userauth.serviceImpl;
//
//import java.util.HashSet;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Optional;
//import java.util.Set;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Service;
//
//import com.userauth.constant.AuthConstant;
//import com.userauth.constant.ManitouConstants;
//import com.userauth.entity.Response;
//import com.userauth.entity.Role;
//import com.userauth.entity.User;
//import com.userauth.entity.UserForSave;
//import com.userauth.repository.UserRepository;
//import com.userauth.security.PasswordEncoderUtility;
//import com.userauth.service.RoleService;
//import com.userauth.service.UserService;
//
///*
//*Added by kishan pandey. serviceImple class create the communication between DB and user entity for DB operation
// */
//@Service
//public class UserServiceImpl2 implements UserService {
//
//	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl2.class);
//
//	@Autowired
//	private UserRepository userRepo;
//
//	@Autowired
//	private RoleService roleService;
//
////	@Autowired(required=true)
////	private User user;
//
//	@Override
//	public Response findAllUser() throws Exception {
//		try {
//			logger.info("findAllUser()::::::::: method in UserServiceImpl");
//
//			List<User> alluser = userRepo.findAll();
//			if (alluser.size() == 0) {
//				logger.error("Error::::: No record found");
//				return new Response(AuthConstant.FAILURE, AuthConstant.ERROR_CODE, AuthConstant.NO_RECORD_FOUND);
//			}
//			logger.info("Users fetched successfully !!!!!!!!");
//			return new Response(AuthConstant.SUCCESS, AuthConstant.SUCCESS_CODE, alluser);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			return new Response(AuthConstant.FAILURE, AuthConstant.ERROR_CODE, e.getMessage());
//		}
//	}
//
//	@Override
//	public User findByUserId(String userId) {
//		User user = userRepo.findByUserId(userId);
//		return user;
//	}
//
//	@Override
//	public Response findById(Long id) throws Exception {
//		try {
//			logger.info("findByUserId():::method in UserServiceImpl");
//
//			Optional<User> user = userRepo.findById(id);
//
//			if (user.isPresent()) {
//				logger.info("User details are fetched successfully for userid :::::: " + id);
//				return new Response(AuthConstant.SUCCESS, AuthConstant.SUCCESS_CODE, user);
//			} else {
//				logger.error("No record found for the userid :::::::::: " + id);
//				return new Response(AuthConstant.FAILURE, AuthConstant.ERROR_CODE, AuthConstant.NO_RECORD_FOUND);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			logger.error("Error:::::::::: in findByUserId()");
//			return new Response(AuthConstant.FAILURE, AuthConstant.ERROR_CODE, e.getMessage());
//		}
//	}
//
//	public User findByUserName(String l_username) {
//
//		return userRepo.findByUserName(l_username);
//	}
//
//	@Override
//	public Response saveUser(UserForSave user) {
//		try {
//			logger.info("saveUser()::::::: method in UserServiceImpl");
//
//			Optional<User> ofNullable = Optional.ofNullable(userRepo.findByUserId(user.getUserId()));
//
//			if (!ofNullable.isPresent()) {
//				User user2 = new User();
//
//				user2.setUserId(user.getUserId());
//				user2.setUserName(user.getUserName());
//				user2.setPassword(PasswordEncoderUtility.passwordEncoder(user.getPassword()));
//				user2.setMobile(user.getMobile());
//				user2.setEmail(user.getEmail());
//				user2.setLocked_status("N");
//				user2.setIncorrect_attempt(0);
//				user2.setIncorrect_max_attempt_limit(ManitouConstants.INCORRECT_MAX_ATTEMPT_LIMIT);
//				user2.setFisrt_login_status("N");
//				user2.setStatus("N");
//
////			user.setPassword(PasswordEncoderUtility.passwordEncoder(user.getPassword()));
////			user.setLocked_status("N");
////			user.setIncorrect_attempt(0);
////			user.setIncorrect_max_attempt_limit(ManitouConstants.INCORRECT_MAX_ATTEMPT_LIMIT);
////			user.setFisrt_login_status("N");
////			user.setStatus("N");
//
//				if (user.getRoleId() != null) {
//					Role role = (Role) roleService.getRoleById(Long.parseLong(user.getRoleId())).getData();
//					Set<Role> roles=new HashSet<>();
//					roles.add(new Role(1L,"SUPERADMIN","Super Admin"));
//					user2.setRoles(roles);
//				}
//
//				User saveUser = userRepo.save(user2);
//				return new Response(AuthConstant.SUCCESS, AuthConstant.SUCCESS_CODE, saveUser);
//			} else {
//				logger.error("Error:::::::::::::Data already exist for userid " + user.getUserId());
//				return new Response(AuthConstant.FAILURE, AuthConstant.ERROR_CODE, AuthConstant.DATA_EXIST);
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			e.getMessage();
//			return new Response(AuthConstant.FAILURE, AuthConstant.ERROR_CODE, e.getMessage());
//		}
//	}
//
//	@Override
//	public Response updateUser(UserForSave user) throws Exception {
//
//		try {
//			logger.info("updateUser()::::::: method in UserServiceImpl");
//
//			Optional<User> userData = Optional.ofNullable(findByUserId(user.getUserId()));
////			User userData=findByUserId(user.getUserId());
//
//			Optional<Authentication> _checkauthentication = Optional
//					.ofNullable(SecurityContextHolder.getContext().getAuthentication());
//
//			String username = "";
//			if (_checkauthentication.isPresent()) {
//				Object principal = _checkauthentication.get().getPrincipal();
//				if (principal instanceof UserDetails) {
//					username = ((UserDetails) principal).getUsername();
//
//				}
//			}
//
//			User findByUserName = findByUserName(username);
//			if (userData.isPresent()) {
//				if (userData.get().getRoles().getRoleName().equals("SUPERADMIN")
//						|| userData.get().getUserId().equals(findByUserName.getUserId())) {
//
////					User user2 = new User();
//
//					userData.get().setUserName(user.getUserName());
//					userData.get().setPassword(PasswordEncoderUtility.passwordEncoder(user.getPassword()));
//					userData.get().setMobile(user.getMobile());
//					userData.get().setEmail(user.getEmail());
//
//					if (user.getRoleId() != null) {
//						Role role = (Role) roleService.getRoleById(Long.parseLong(user.getRoleId())).getData();
//						userData.get().setRoles(role);
//					}
//
//					User saveUser = userRepo.save(userData.get());
//					logger.info("user data updated successfully.......");
//					return new Response(AuthConstant.SUCCESS, AuthConstant.SUCCESS_CODE, saveUser);
//				} else {
//					logger.error("Error::::::::::User is not authorized to upadate the data");
//					return new Response(AuthConstant.FAILURE, AuthConstant.ERROR_CODE, AuthConstant.USER_UNAUTHORIZED);
//				}
//			} else {
//				logger.error("Error::::::::::Userid not present");
//				return new Response(AuthConstant.FAILURE, AuthConstant.ERROR_CODE, AuthConstant.USERID_NOT_PRESENT);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			return new Response(AuthConstant.FAILURE, AuthConstant.ERROR_CODE, e.getMessage());
//		}
//	}
//
//	@Override
//	public Response deleteUserById(String userId) throws Exception {
//		logger.info("deleteUserById():::::: method in UserServiceImpl " + userId);
//		try {
//			int deletedUser = userRepo.deleteByUserId(userId);
//
//			if (deletedUser == 0) {
//				logger.error("No record found to delete for userid ::: "+userId);
//				return new Response(AuthConstant.FAILURE, AuthConstant.ERROR_CODE, AuthConstant.NO_RECORD_FOUND);
//			} else {
//				logger.error("Record deleted for userid ::: "+userId);
//				return new Response(AuthConstant.SUCCESS, AuthConstant.SUCCESS_CODE, AuthConstant.RECORD_DELETED);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			e.getMessage();
//			return new Response(AuthConstant.FAILURE, AuthConstant.ERROR_CODE, e.getMessage());
//
//		}
//	}
//}

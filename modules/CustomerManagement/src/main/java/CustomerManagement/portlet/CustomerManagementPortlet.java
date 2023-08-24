package CustomerManagement.portlet;

import CustomerManagement.constants.CustomerManagementPortletKeys;
import customerManagementService.model.Customer;
import customerManagementService.model.Services;
import customerManagementService.service.CustomerLocalService;
import customerManagementService.service.CustomerLocalServiceUtil;
import customerManagementService.service.ServicesLocalService;
import customerManagementService.service.ServicesLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.UserServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author sinyi
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=CustomerManagement", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + CustomerManagementPortletKeys.CUSTOMERMANAGEMENT,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class CustomerManagementPortlet extends MVCPortlet {
	// Services
	public void addService(ActionRequest req, ActionResponse res) throws Exception {
		_addService(req);
		String redirectURL = ParamUtil.getString(req, "redirectURL");
		res.sendRedirect(redirectURL);
	}

	public void updateService(ActionRequest req, ActionResponse res) throws Exception {
		_updateService(req);
		sendRedirect(req, res);
	}

	public void deleteService(ActionRequest req, ActionResponse res) throws Exception {
		long serviceId = ParamUtil.getLong(req, "serviceId");
		ServicesLocalServiceUtil.deleteService(serviceId);
		sendRedirect(req, res);
	}

	// Customers
	public void addCustomer(ActionRequest req, ActionResponse res) throws Exception {
		_addCustomer(req);
		String redirectURL = ParamUtil.getString(req, "redirectURL");
		res.sendRedirect(redirectURL);
	}

	public void updateCustomer(ActionRequest req, ActionResponse res) throws Exception {
		_updateCustomer(req);
		sendRedirect(req, res);
	}

	public void deleteCustomer(ActionRequest req, ActionResponse res) throws Exception {
		long customerId = ParamUtil.getLong(req, "customerId");
		CustomerLocalServiceUtil.deleteCustomer(customerId);
		sendRedirect(req, res);
	}

	// Private Methods
	private Services _addService(ActionRequest req) throws PortalException, SystemException {
		Services service = null;
		if (req.getRemoteUser() != null) {
			User user = UserServiceUtil.getUserById(Long.parseLong(req.getRemoteUser()));
			// For audit fields
			long userId = user.getUserId();
			long groupId = user.getGroupId();
			String userName = user.getFullName();

			String serviceName = ParamUtil.getString(req, "serviceName");
			String serviceType = ParamUtil.getString(req, "serviceType");
			String serviceSpecification = ParamUtil.getString(req, "serviceSpecification");
			String servicePlan = ParamUtil.getString(req, "servicePlan");
			double servicePrice = ParamUtil.getDouble(req, "servicePrice");

			service = ServicesLocalServiceUtil.addService(serviceName, serviceType, serviceSpecification, servicePlan,
					servicePrice, userId, groupId, userName);
		}

		return service;
	}

	private Services _updateService(ActionRequest req) throws PortalException, SystemException {
		long serviceId = ParamUtil.getLong(req, "serviceId");
		String serviceName = ParamUtil.getString(req, "serviceName");
		String serviceType = ParamUtil.getString(req, "serviceType");
		String serviceSpecification = ParamUtil.getString(req, "serviceSpecification");
		String servicePlan = ParamUtil.getString(req, "servicePlan");
		double servicePrice = ParamUtil.getDouble(req, "servicePrice");

		Services service = ServicesLocalServiceUtil.getServices(serviceId);
		service = ServicesLocalServiceUtil.updateService(serviceId, serviceName, serviceType, serviceSpecification,
				servicePlan, servicePrice);
		
		return service;
	}

	private Customer _addCustomer(ActionRequest req) throws PortalException, SystemException {
		Customer customer = null;
		if (req.getRemoteUser() != null) {
			User user = UserServiceUtil.getUserById(Long.parseLong(req.getRemoteUser()));
			// For audit fields
			long userId = user.getUserId();
			long groupId = user.getGroupId();
			String userName = user.getFullName();

			String customerName = ParamUtil.getString(req, "customerName");
			String customerIdentityNo = ParamUtil.getString(req, "customerIdentityNo");
			String customerEmail = ParamUtil.getString(req, "customerEmail");
			String customerAddress = ParamUtil.getString(req, "customerAddress");
			String customerContactNo = ParamUtil.getString(req, "customerContactNo");

			customer = CustomerLocalServiceUtil.addCustomer(customerName, customerIdentityNo, customerEmail,
					customerAddress, customerContactNo, userId, groupId, userName);
		}
		
		return customer;
	}

	private Customer _updateCustomer(ActionRequest req) throws PortalException, SystemException {
		long customerId = ParamUtil.getLong(req, "customerId");
		String customerName = ParamUtil.getString(req, "customerName");
		String customerIdentityNo = ParamUtil.getString(req, "customerIdentityNo");
		String customerEmail = ParamUtil.getString(req, "customerEmail");
		String customerAddress = ParamUtil.getString(req, "customerAddress");
		String customerContactNo = ParamUtil.getString(req, "customerContactNo");
		String selectedServices = ParamUtil.getString(req, "selectedServicesHidden");

		if (selectedServices.equals("deleteAll")) {
			// Delete all rows in the customers_services table for the specified customerId
			List<Services> serviceList = ServicesLocalServiceUtil.getServiceses(0,
					ServicesLocalServiceUtil.getServicesesCount());
			
			ServicesLocalServiceUtil.deleteCustomerServiceses(customerId, serviceList);
		} else {
			long defaultValue = 0;
			long[] serviceIdsArray = StringUtil.split(selectedServices, ";", defaultValue);
			for (int i = 0; i < serviceIdsArray.length; i++) {
				ServicesLocalServiceUtil.setCustomerServiceses(customerId, serviceIdsArray);
			}
		}

		Customer customer = CustomerLocalServiceUtil.getCustomer(customerId);
		customer = CustomerLocalServiceUtil.updateCustomer(customerId, customerName, customerIdentityNo, customerEmail,
				customerAddress, customerContactNo);
		
		return customer;
	}

	@Reference
	private CustomerLocalService _customerLocalService;

	@Reference
	private ServicesLocalService _servicesLocalService;
}
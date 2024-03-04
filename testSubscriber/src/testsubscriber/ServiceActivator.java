package testsubscriber;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import testpublisher.ServicePublish;

public class ServiceActivator implements BundleActivator {

	ServiceReference serviceReference;
	
	public void start(BundleContext context) throws Exception {
		System.out.println("Subscriber Start..");
		serviceReference = context.getServiceReference(ServicePublish.class.getName());
		ServicePublish servicePublish = (ServicePublish) context.getService(serviceReference);
		System.out.println(servicePublish.publishService());
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Subcriber Stop..");
		context.ungetService(serviceReference);
	}

}

package org.energyos.espi.datacustodian.utils.factories;

import org.energyos.espi.datacustodian.domain.*;
import org.energyos.espi.datacustodian.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Calendar;

@Component
public class EspiPersistenceFactory {
    @Autowired
    private ThirdPartyService thirdPartyService;
    @Autowired
    private RetailCustomerService retailCustomerService;
    @Autowired
    private SubscriptionService subscriptionService;
    @Autowired
    private AuthorizationService authorizationService;
    @Autowired
    private UsagePointService usagePointService;

    public Subscription createSubscription() {
        ThirdParty thirdParty = EspiFactory.newThirdParty();
        thirdPartyService.persist(thirdParty);
        RetailCustomer retailCustomer = EspiFactory.newRetailCustomer();
        retailCustomerService.persist(retailCustomer);

        Subscription subscription = EspiFactory.newSubscription(retailCustomer, thirdParty);
        subscription.setLastUpdate(Calendar.getInstance());
        subscriptionService.persist(subscription);

        return subscription;
    }

    public Authorization createAuthorization() {
        Subscription subscription = createSubscription();
        Authorization authorization = EspiFactory.newAuthorization(subscription);
        authorizationService.persist(authorization);

        return authorization;
    }

    public RetailCustomer createRetailCustomer() {
        RetailCustomer retailCustomer = EspiFactory.newRetailCustomer();
        retailCustomerService.persist(retailCustomer);

        return retailCustomer;
    }

    public UsagePoint createUsagePoint() {
        UsagePoint usagePoint = EspiFactory.newUsagePoint(createRetailCustomer());
        usagePointService.persist(usagePoint);

        return usagePoint;
    }

    public ThirdParty createThirdParty() {
        ThirdParty thirdParty = EspiFactory.newThirdParty();
        thirdPartyService.persist(thirdParty);

        return thirdParty;
    }
}

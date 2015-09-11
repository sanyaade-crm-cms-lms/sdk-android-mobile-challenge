Guide for Android SDK - CitiMobileChallenge
Version 2
=====================
##### Table of Contents 
[Setup](#setup) 

[Certificate Pinning](#certpinning)

[CRUD](#crud) 

[Local Cache](#localcache)

[Push Notifications](#push)

[Troubleshooting](#troubleshooting)

<a name="setup"/>
## Setup

### Android
Before the SDK can be used for Android. You need to set it up by calling 
APSetup.setup(Context). This will setup the sdk according to 
what was defined from the AnyPresence designer and initializes the 
local cache.

For example:

```
public class APApplication extends Application {
  @Override
  public void onCreate() {
    APSetup.setup(this)
  }
}
```
### Java
For Java, we simply call APSetup.setup() to setup the SDK.

<a name="certpinning"/>
## Certificate Pinning

Certificate pinning ties a host to their expected X509 certificate. Once enabled, all https connections will 
be verified against the certificates were pinned.

```
// Enable certificate pinning
RemoteRailsConfig.getInstance().setUseCertPinning(true);

// Add your certificate for 'https://yoursite.com'
RemoteRailsConfig.getInstance().addCertForPinning("yoursite.com", getAssets().open("server.cert"));

// Toggles the feature off
RemoteRailsConfig.getInstance().setUseCertPinning(false);

```

<a name="crud"/>
## CRUD methods
The CRUD methods have synchronous and asynchronous versions. You will use these methods to interact with the backend.
We'll use Foo as an example class.

Note that thee current SDK has these objects:
  CapitalMarketsActivity
  CapitalMarketsContact
  CapitalMarketsContentService
  CapitalMarketsLogin
  CapitalMarketsOrder
  CapitalMarketsRevenue
  CorporatePaymentsAccount
  CorporatePaymentsBeneficiary
  CorporatePaymentsCrossBorderFxBooking
  CorporatePaymentsCrossBorderFxPayment
  CorporatePaymentsCrossBorderFxQuote
  CorporatePaymentsLogin
  CorporatePaymentsPayment
  RetailBankingAccount
  RetailBankingAccountBalance
  RetailBankingAccountFundTransfer
  RetailBankingAccountTransaction
  RetailBankingForeignCurrency
  RetailBankingLocation
  RetailBankingLogin
  RetailBankingPayee
  RetailBankingPayeeType

### Create (synchronous)

```
Foo foo = new Foo();
foo.setField0("test");

foo.save();
```

### Create (asynchronous)

```
Foo foo = new Foo();
foo.setField0("test");

foo.saveInBackground(new APCallback<Foo>() {
      @Override
      public void finished(Foo foo, Throwable err) {
        if (err == null) {
          // Successfully saved object
        } else {
          // There was an error
        }
          
      }
});

```
### Read (synchronous)

```
Foo foo = Foo.fetch("123456");
```

### Read (asynchronous)
```
Foo.fetchInBackground("123456", new APCallback<Foo>() {
      @Override
      public void finished(Foo foo, Throwable err) {
        if (err == null) {
          // Successfully fetched object
        } else {
          // There was an error
        }
          
      }
});
```

### Read - Query scopes (synchronous)

```
Map<String,String> params = new HashMap<>();
params.put("foo0", "bar0");

// Use the 'all' query scope, offset 0 and limit 5
Foo.query("all", params, 0, 5);

```

### Read - Query scopes (asynchronous)

```
Map<String,String> params = new HashMap<>();
params.put("foo0", "bar0");

// Use the 'all' query scope, offset 0 and limit 5
Foo.queryInBackground("all", params, 0, 5, new APCallback<List<Foo>>() {
      @Override
      public void finished(List<Foo> foos, Throwable err) {
        if (err == null) {
          // Successfully fetched objects
        } else {
          // There was an error
        }
          
      }
});

```

### Read - Query scopes with context

```
RemoteRequest.RemoteRequestBuilder remoteRequestBuilder = (HttpAdapter)RemoteRailsConfig.getRouterAdapterByClass(Foo.class).createRemoteRequestBuilder(RequestMethod.GET, Foo.class);
RemoteRequest remoteRequest = remoteRequestBuilder.createRemoteRequest();

// Set the context where the context can be a hash or a RemoteObject 
remoteRequest.setContext(context);

// Set the scope
remoteRequest.setQuery("all");

// Set the parameters
remoteRequest.setParameters(params);

Foo.queryInBackground(remoteRequest, 0, 5, new APCallback<List<Foo>>() {
      @Override
      public void finished(List<Foo> foos, Throwable err) {
        if (err == null) {
          // Successfully fetched objects
        } else {
          // There was an error
        }
      }
});
```

### Update (synchronous)

Just use the methods for create.

### Update (synchronous)

Just use the methods for create.

### Delete (synchronous)

```
foo.delete();
```

### Delete (asynchronous)

```
foo.deleteInBackground(new APCallback<Foo>() {
      @Override
      public void finished(Foo foo, Throwable err) {
        if (err == null) {
          // Successfully delted object
        } else {
          // There was an error
        }
          
      }
});)
```

<a name="localcache"/>
## Local Cache

If caching is enabled, requests made to the backend will be cached. These items in the cache can then be retrieved by various methods that are available. Please refer to the 'setup' section 
for instructions to setup caching.

```
// Query with the 'all' scope and suppose there's an object with a remote id of "123" returned.
Foo.queryInBackground(
        Foo.Scopes.ALL,
        new APFutureCallback<List<Foo>>() {
          @Override
          public void finished(List<Foo> arg0, Throwable ex) {
            // Do nothing
          }
        });

// Fetch Foo objects in cache with remote object id of "123"
List<Foo> objects = Foo.fetchInCacheWithObjectIdPredicate("123");

// Another example of fetching Foo objects in cache with remote object id of "123"
Map<String, String> predicates = new HashMap<String, String>();
predicates.put("ObjectId", "123");
Foo.fetchInCacheWithPredicates(predicates)

```

Note that fetchInCacheWithPredicates(Map<String,String>) does the search using fields that correspond to the GreenDAO models. For Foo, we need to refer to dao.FooDao.Properties to know what those fields are. The parameter names should just be the Propery name.


We can also retrieve data from the local cache using parameters and scopes that exactly match what was used for the query scope methods.

```
// Query with the 'all' scope.
Foo.queryInBackground(
        Foo.Scopes.ALL,
        new APFutureCallback<List<Foo>>() {
          @Override
          public void finished(List<Foo> arg0, Throwable ex) {
            // Do nothing
          }
        });

// At a later time we can fetch in cache by searching for requests matching the exact scope.
List<Foo> objects = Foo.fetchInCacheWithParameterPredicate(Foo.Scopes.ALL);

```

```
// Query with the 'all' scope and some parameters (synchronous this time)
Map<String, String> params = new HashMap<String, String>();
params.put("bar", "fake");

Foo.query(Foo.Scopes.ALL, params);

// At a later time we can fetch in cache by searching for requests matching the exact scope and params.
Foo.fetchInCacheWithParameterPredicate(Foo.Scopes.ALL, params);

```


<a name="push"/>
## Push Notifications
To be able to push messages onto devices, you must register devices and then subscribe devices into channels.

### Register

```
PushNotification.registerDevice("12345", new APCallback<String>() {
    @Override
    public void finished(String result, Throwable err) {
        if (err == null) {
            // Successfully registered
        } else {
            // Not able to register
            err.printStackTrace();
        }
    }
});
```

### Subscribe

```
PushNotification.subscribeToChannel("channel0", "12345", PushNotification.Provider.ANDROID, new APCallback<String>() {
    @Override
    public void finished(String result, Throwable err) {
        if (err == null) {
            // Successfully subscribed
        } else {
            // Not able to subscribe
            err.printStackTrace();
        }
    }
});
```

### Unsubscribe

```
PushNotification.unsubscribeFromChannel("channel0", "12345", PushNotification.Provider.ANDROID, new APCallback<String>() {
    @Override
    public void finished(String result, Throwable err) {
        if (err == null) {
            // Successfully unsubscribed
        } else {
            // Not able to unsubscribe
            err.printStackTrace();
        }
    }
});
```

### Sends message to channel

```
IOSNotificationData iosData = new IOSNotificationData();
iosData.setAlert("alert!");

AndroidNotificationData androidData = new AndroidNotificationData();
androidData.setCollapseKey("my_key")

PushNotification.sendMessage("channel0", "Hello!", iosData, androidData,  new APCallback<String>() {
    @Override
    public void finished(String result, Throwable err) {
        if (err == null) {
            // Successfully sent message
        } else {
            // Not able to send message
            err.printStackTrace();
        }
    }
});
```


<a name="troubleshooting"/>
## Troubleshooting
Debug logs can be obtained by calling this method:

```
APSetup.enableDebugMode()
```



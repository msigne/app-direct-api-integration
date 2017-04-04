package app.direct.api.domain.enumeration;

public enum OrderStatus {
    INITIALIZED, 
    PENDING_USER_APPROVAL, 
    PENDING_REMOTE_CREATION, 
    FREE_TRIAL, 
    ACTIVE, 
    FINISHED, 
    ONE_TIME, 
    CANCELLED, 
    SUSPENDED, 
    FREE_TRIAL_EXPIRED, 
    FREE_TRIAL_CANCELLED, 
    DELETED, 
    FAILED, 
    UPCOMING, 
    PENDING_MIGRATION_ACTIVATION;
}

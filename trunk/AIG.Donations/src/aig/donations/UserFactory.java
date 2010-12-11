package aig.donations;

import aig.donations.exceptions.IllegalParameterException;
import aig.donations.exceptions.IncompatiblePrivilegesException;

/**
 * A factory class for converting a user to one of his subclasses. The class
 * checks that the user is of an appropriate role before returning an instance
 * of the subclass.
 * 
 */
public class UserFactory {
  
  /**
   * Converts the user to a SocialWorker
   * 
   * @param user
   *          - a user to convert
   * @return a SocialWorker who is the given user
   * @throws IncompatiblePrivilegesException
   *           if the user isn't of an appropriate role
   */
  public static SocialWorker createSocialWorker(User user) throws IncompatiblePrivilegesException {
    if (Role.SOCIAL_WORKER.equals(user.getRole()) || Role.SYSTEM_ADMIN.equals(user.getRole())) {
      try {
        return new SocialWorker(user);
      } catch (IllegalParameterException e) {
        throw new AssertionError(e);
      }
    }
    throw new IncompatiblePrivilegesException("social worker");
  }
  
  /**
   * Converts the user to a Donor
   * 
   * @param user
   *          - a user to convert
   * @return a Donor who is the given user
   * @throws IncompatiblePrivilegesException
   *           if the user isn't of an appropriate role
   */
  public static Donor createDonor(User user) throws IncompatiblePrivilegesException {
    if (Role.DONOR.equals(user.getRole()) || Role.SYSTEM_ADMIN.equals(user.getRole())) {
      try {
        return new Donor(user);
      } catch (IllegalParameterException e) {
        throw new AssertionError(e);
      }
    }
    throw new IncompatiblePrivilegesException("donor");
  }
  
  /**
   * Converts the user to a Receiver
   * 
   * @param user
   *          - a user to convert
   * @return a Receiver who is the given user
   * @throws IncompatiblePrivilegesException
   *           if the user isn't of an appropriate role
   */
  public static Receiver createReceiver(User user) throws IncompatiblePrivilegesException {
    if (Role.RECEIVER.equals(user.getRole()) || Role.SYSTEM_ADMIN.equals(user.getRole())) {
      try {
        return new Receiver(user);
      } catch (IllegalParameterException e) {
        throw new AssertionError(e);
      }
    }
    throw new IncompatiblePrivilegesException("receiver");
  }
  
  /**
   * Converts the user to a SystemAdmin
   * 
   * @param user
   *          - a user to convert
   * @return a SystemAdmin who is the given user
   * @throws IncompatiblePrivilegesException
   *           if the user isn't of an appropriate role
   */
  public static SystemAdmin createSystemAdmin(User user) throws IncompatiblePrivilegesException {
    if (Role.SYSTEM_ADMIN.equals(user.getRole())) {
      try {
        return new SystemAdmin(user);
      } catch (IllegalParameterException e) {
        throw new AssertionError(e);
      }
    }
    throw new IncompatiblePrivilegesException("administration");
  }
  
  /**
   * Converts the user to a Reporter
   * 
   * @param user
   *          - a user to convert
   * @return a Reporter who is the given user
   * @throws IncompatiblePrivilegesException
   *           if the user isn't of an appropriate role
   */
  public static Reporter createReporter(User user) throws IncompatiblePrivilegesException {
    if (Role.SOCIAL_WORKER.equals(user.getRole()) || Role.SYSTEM_ADMIN.equals(user.getRole())) {
      try {
        return new Reporter(user);
      } catch (IllegalParameterException e) {
        throw new AssertionError(e);
      }
    }
    throw new IncompatiblePrivilegesException("reporting");
  }
  
}

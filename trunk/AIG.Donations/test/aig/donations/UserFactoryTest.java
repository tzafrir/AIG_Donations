package aig.donations;

import org.junit.Test;

import aig.donations.exceptions.IncompatiblePrivilegesException;

public class UserFactoryTest {
  
  User receiver, donor, socialWorker, systemAdmin;
  
  public UserFactoryTest() throws Exception{
    receiver     = new User("alice", Role.RECEIVER, "Alice P");
    donor        = new User("Mad_Hatter", Role.DONOR, "Johnny Depp");
    socialWorker = new User("kitty", Role.SOCIAL_WORKER, "Cheshire Cat");
    systemAdmin  = new User("smokey", Role.SYSTEM_ADMIN, "Caterpillar");
  }
  
  /* convert from Receiver: */

  @Test(expected = IncompatiblePrivilegesException.class)
  public void testCreateSocialWorkerFromReceiver() throws IncompatiblePrivilegesException {
    UserFactory.createSocialWorker(receiver);
  }
  
  @Test(expected = IncompatiblePrivilegesException.class)
  public void testCreateDonorFromReceiver() throws IncompatiblePrivilegesException {
    UserFactory.createDonor(receiver);
  }
  
  @Test
  public void testCreateReceiverFromReceiver() throws IncompatiblePrivilegesException {
    UserFactory.createReceiver(receiver);
  }
  
  @Test(expected = IncompatiblePrivilegesException.class)
  public void testCreateSystemAdminFromReceiver() throws IncompatiblePrivilegesException {
    UserFactory.createSystemAdmin(receiver);
  }
  
  @Test(expected = IncompatiblePrivilegesException.class)
  public void testCreateReporterFromReceiver() throws IncompatiblePrivilegesException {
    UserFactory.createReporter(receiver);
  }
  
  /* convert from Donor: */

  @Test(expected = IncompatiblePrivilegesException.class)
  public void testCreateSocialWorkerFromDonor() throws IncompatiblePrivilegesException {
    UserFactory.createSocialWorker(donor);
  }
  
  @Test
  public void testCreateDonorFromDonor() throws IncompatiblePrivilegesException {
    UserFactory.createDonor(donor);
  }
  
  @Test(expected = IncompatiblePrivilegesException.class)
  public void testCreateReceiverFromDonor() throws IncompatiblePrivilegesException {
    UserFactory.createReceiver(donor);
  }
  
  @Test(expected = IncompatiblePrivilegesException.class)
  public void testCreateSystemAdminFromDonor() throws IncompatiblePrivilegesException {
    UserFactory.createSystemAdmin(donor);
  }
  
  @Test(expected = IncompatiblePrivilegesException.class)
  public void testCreateReporterFromDonor() throws IncompatiblePrivilegesException {
    UserFactory.createReporter(donor);
  }
  
  /* convert from SocialWorker: */

  @Test
  public void testCreateSocialWorkerFromSocialWorker() throws IncompatiblePrivilegesException {
    UserFactory.createSocialWorker(socialWorker);
  }
  
  @Test(expected = IncompatiblePrivilegesException.class)
  public void testCreateDonorFromSocialWorker() throws IncompatiblePrivilegesException {
    UserFactory.createDonor(socialWorker);
  }
  
  @Test(expected = IncompatiblePrivilegesException.class)
  public void testCreateReceiverFromSocialWorker() throws IncompatiblePrivilegesException {
    UserFactory.createReceiver(socialWorker);
  }
  
  @Test(expected = IncompatiblePrivilegesException.class)
  public void testCreateSystemAdminFromSocialWorker() throws IncompatiblePrivilegesException {
    UserFactory.createSystemAdmin(socialWorker);
  }
  
  @Test
  public void testCreateReporterFromSocialWorker() throws IncompatiblePrivilegesException {
    UserFactory.createReporter(socialWorker);
  }
  
  /* convert from SystemAdmin: */

  @Test
  public void testCreateSocialWorkerFromSystemAdmin() throws IncompatiblePrivilegesException {
    UserFactory.createSocialWorker(systemAdmin);
  }
  
  @Test
  public void testCreateDonorFromSystemAdmin() throws IncompatiblePrivilegesException {
    UserFactory.createDonor(systemAdmin);
  }
  
  @Test
  public void testCreateReceiverFromSystemAdmin() throws IncompatiblePrivilegesException {
    UserFactory.createReceiver(systemAdmin);
  }
  
  @Test
  public void testCreateSystemAdminFromSystemAdmin() throws IncompatiblePrivilegesException {
    UserFactory.createSystemAdmin(systemAdmin);
  }
  
  @Test
  public void testCreateReporterFromSystemAdmin() throws IncompatiblePrivilegesException {
    UserFactory.createReporter(systemAdmin);
  }
  
}

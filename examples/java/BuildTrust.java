import io.digitalbits.base.Asset;
import io.digitalbits.base.ChangeTrustOperation;
import io.digitalbits.base.Keypair;
import io.digitalbits.base.PaymentOperation;
import io.digitalbits.base.Transaction;
import io.digitalbits.sdk.Account;
import io.digitalbits.sdk.Server;
import io.digitalbits.sdk.SubmitTransactionResponse;

import java.io.IOException;

/**
 * This example illustrates how to build trust between two parties and then use that trust to
 * transfer credit in a non-native currency.
 *
 * @author Myrle Krantz
 */
public class BuildTrust {

  //The community is the source of the credits, and the target of the trust.
  static final Keypair COMMUNITY_ACCOUNT_KEY_PAIR =
      Keypair.fromSecretSeed("SA4RSNOG7WP5SY25NB3UDFY432BIJDVPSO6OHV5JY7THM745URP3VE22");

  //The programmer is the source of the trust, and the target of the credits.
  static final Keypair COOL_PROGRAMMER_ACCOUNT_KEY_PAIR =
      Keypair.fromSecretSeed("SBB4LZ6OHDFNPGOBVUW3VJ4YJPYMJ7GJM5RBYTD6L7YPMSUGVMLLI5LK");

  //The currency we are transferring is street cred.
  static final Asset STREET_CRED = Asset.createNonNativeAsset("STC", COMMUNITY_ACCOUNT_KEY_PAIR);


  public static void main(String[] args) throws IOException {
    final Server digitalbitsServer = new Server("https://frontier.testnet.digitalbits.io");

    //Build trust.
    System.out.println("Build trust...");
    final SubmitTransactionResponse coolProgrammerTrustsCommunityResponse =
        coolProgrammerTrustsCommunity(digitalbitsServer, 2000);
    printResponse(coolProgrammerTrustsCommunityResponse);

    //Transfer street creds.  If this fails, check if the community has enough lumens for the
    //transfer fees.
    System.out.println("Pay street creds...");
    final SubmitTransactionResponse communityPaysItsDueResponse =
        communityPaysItsDue(digitalbitsServer, 100);
    printResponse(communityPaysItsDueResponse);
  }

  /**
   * Creates a trustline between the programmer and the community.  This makes it possible for the
   * programmer to accept credits from the community.
   *
   * @param digitalbitsServer The Server to exercise this on.
   * @param maximumAmount The maximum amount of trust.
   * @return The response that the server returns.
   *
   * @throws IOException
   */
  private static SubmitTransactionResponse coolProgrammerTrustsCommunity(final Server digitalbitsServer,
                                                 final int maximumAmount)
      throws IOException
  {
    //Get the account with the current ledger number.
    final Account coolProgrammerAccount =
        digitalbitsServer.accounts().account(COOL_PROGRAMMER_ACCOUNT_KEY_PAIR);

    //Create a trust line.  The programmer trusts the community.
    //Add this operation to the transaction.
    final Transaction.Builder trustTransactionBuilder =
        new Transaction.Builder(coolProgrammerAccount);

    final ChangeTrustOperation trustOperation =
        new ChangeTrustOperation.Builder(STREET_CRED, Integer.toString(maximumAmount)).build();

    trustTransactionBuilder.addOperation(trustOperation);
    final Transaction trustTransaction = trustTransactionBuilder.build();

    //The cool programmer signs the transaction
    trustTransaction.sign(COOL_PROGRAMMER_ACCOUNT_KEY_PAIR);

    //And the transaction gets sent off to the server.
    return digitalbitsServer.submitTransaction(trustTransaction);
  }

  /**
   * The community transfers street cred to the programmer
   *
   * @param digitalbitsServer The Server to exercise this on.
   * @param amount how much street cred the programmer is receiving.
   * @return The response that the server returns.
   *
   * @throws IOException
   */
  private static SubmitTransactionResponse communityPaysItsDue(final Server digitalbitsServer,
                                                               final int amount)
      throws IOException
  {
    //Get the account with the current ledger number.
    final Account sourceAccount = digitalbitsServer.accounts().account(COMMUNITY_ACCOUNT_KEY_PAIR);

    //Create a payment transaction.  Source is the community, and target is the programmer.
    final Transaction.Builder transferTransactionBuilder =
        new Transaction.Builder(sourceAccount);

    final PaymentOperation paymentOperation =
        new PaymentOperation.Builder(
            COOL_PROGRAMMER_ACCOUNT_KEY_PAIR, STREET_CRED,Integer.toString(amount)).
            setSourceAccount(COMMUNITY_ACCOUNT_KEY_PAIR).build();

    transferTransactionBuilder.addOperation(paymentOperation);
    final Transaction transferTransaction = transferTransactionBuilder.build();

    //The community signs the operation.
    transferTransaction.sign(COMMUNITY_ACCOUNT_KEY_PAIR);

    //And the transaction gets sent off to the server.
    return digitalbitsServer.submitTransaction(transferTransaction);
  }

  /**
   * Output the contents of the response to the console.
   * @param response the response from the digitalbits Server
   */
  private static void printResponse(final SubmitTransactionResponse response) {

    System.out.println("Successful? " + response.isSuccess());
    System.out.println("Ledger# " + response.getLedger());


    final SubmitTransactionResponse.Extras extras = response.getExtras();
    if (extras != null) {
      System.out.println("TransactionResult: " + extras.getResultXdr());
      System.out.println("TransactionEnvelope: " + extras.getEnvelopeXdr());
    }
    else {
      if (!response.isSuccess()) {
        System.out.println("Extras = null"); //Extras are always null if the response is a success.
      }
    }
  }
}

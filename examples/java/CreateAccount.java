import io.digitalbits.base.CreateAccountOperation;
import io.digitalbits.base.Keypair;
import io.digitalbits.base.Memo;
import io.digitalbits.base.Transaction;
import io.digitalbits.sdk.Account;
import io.digitalbits.sdk.Server;
import io.digitalbits.sdk.SubmitTransactionResponse;

import java.io.IOException;

/**
 * This example illustrates how to create a new account using an existing account.  The new account
 * receives 20 lumens from the existing account.
 *
 * @author Myrle Krantz
 */
public class CreateAccount {
  public static void main(String[] args) throws IOException {
    final Server digitalbitsServer = new Server("https://frontier.testnet.digitalbits.io");

    // Create a public and private key for the new account.
    final Keypair newAccountKeyPair = Keypair.random();
    System.out.println("New account secret seed: " + newAccountKeyPair.getSecretSeed());

    // Get the private key and the ledger number for the existing account.
    final Keypair existingAccountKeyPair = Keypair.fromSecretSeed("SBB4LZ6OHDFNPGOBVUW3VJ4YJPYMJ7GJM5RBYTD6L7YPMSUGVMLLI5LK");
    final Account existingAccount = digitalbitsServer.accounts().account(existingAccountKeyPair);

    //Create a transaction for the existing account which sets up the new account.
    final Transaction.Builder transactionBuilder = new Transaction.Builder(existingAccount);

    final CreateAccountOperation createAccountOperation =
        new CreateAccountOperation.Builder(newAccountKeyPair, Integer.toString(20)).
            setSourceAccount(existingAccountKeyPair).build();

    transactionBuilder.addOperation(createAccountOperation);
    transactionBuilder.addMemo(Memo.text("ExampleAccount"));

    final Transaction createAccountTransaction = transactionBuilder.build();

    //Sign this transaction with the new account, and then submit it to the digitalbits server.
    createAccountTransaction.sign(existingAccountKeyPair);

    System.out.println("Creating account...");
    final SubmitTransactionResponse createAccountResponse = digitalbitsServer.submitTransaction(createAccountTransaction);
    printResponse(createAccountResponse);
  }

  /**
   * Output the contents of the response to the console.
   * @param response the response from the Stellar Server
   */
  private static void printResponse(final SubmitTransactionResponse response)
  {
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

package org.stellar.base;

import org.stellar.base.xdr.AccountID;
import org.stellar.base.xdr.Int64;
import org.stellar.base.xdr.OperationType;
import org.stellar.base.xdr.PaymentOp;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Represents <a href="https://www.stellar.org/developers/learn/concepts/list-of-operations.html#payment" target="_blank">Payment</a> operation.
 * @see <a href="https://www.stellar.org/developers/learn/concepts/list-of-operations.html" target="_blank">List of Operations</a>
 */
public class PaymentOperation extends Operation {

  private final Keypair mDestination;
  private final Asset mAsset;
  private final Long mAmount;

  private PaymentOperation(Keypair destination, Asset asset, Long amount) {
    mDestination = checkNotNull(destination, "destination cannot be null");
    mAsset = checkNotNull(asset, "asset cannot be null");
    mAmount = checkNotNull(amount, "amount cannot be null");
  }

  /**
   * Account that receives the payment.
   */
  public Keypair getDestination() {
    return mDestination;
  }

  /**
   * Asset to send to the destination account.
   */
  public Asset getAsset() {
    return mAsset;
  }

  /**
   * Amount of the asset to send.
   */
  public long getAmount() {
    return mAmount;
  }

  @Override
  org.stellar.base.xdr.Operation.OperationBody toOperationBody() {
    PaymentOp op = new PaymentOp();

    // destination
    AccountID destination = new AccountID();
    destination.setAccountID(mDestination.getXdrPublicKey());
    op.setDestination(destination);
    // asset
    op.setAsset(mAsset.toXdr());
    // amount
    Int64 amount = new Int64();
    amount.setInt64(mAmount);
    op.setAmount(amount);

    org.stellar.base.xdr.Operation.OperationBody body = new org.stellar.base.xdr.Operation.OperationBody();
    body.setDiscriminant(OperationType.PAYMENT);
    body.setPaymentOp(op);
    return body;
  }

  /**
   * Builds Payment operation.
   * @see PathPaymentOperation
   */
  public static class Builder {
    private final Keypair mDestination;
    private final Asset mAsset;
    private final Long mAmount;

    private Keypair mSourceAccount;

    /**
     * Construct a new PaymentOperation builder from a PaymentOp XDR.
     * @param op {@link PaymentOp}
     */
    Builder(PaymentOp op) {
      mDestination = Keypair.fromXdrPublicKey(op.getDestination().getAccountID());
      mAsset = Asset.fromXdr(op.getAsset());
      mAmount = op.getAmount().getInt64().longValue();
    }

    /**
     * Creates a new PaymentOperation builder.
     * @param destination The destination keypair (uses only the public key).
     * @param asset The asset to send.
     * @param amount The amount to send.
     */
    public Builder(Keypair destination, Asset asset, Long amount) {
      mDestination = destination;
      mAsset = asset;
      mAmount = amount;
    }

    /**
     * Sets the source account for this operation.
     * @param account The operation's source account.
     * @return Builder object so you can chain methods.
     */
    public Builder setSourceAccount(Keypair account) {
      mSourceAccount = account;
      return this;
    }

    /**
     * Builds an operation
     */
    public PaymentOperation build() {
      PaymentOperation operation = new PaymentOperation(mDestination, mAsset, mAmount);
      if (mSourceAccount != null) {
        operation.setSourceAccount(mSourceAccount);
      }
      return operation;
    }
  }
}

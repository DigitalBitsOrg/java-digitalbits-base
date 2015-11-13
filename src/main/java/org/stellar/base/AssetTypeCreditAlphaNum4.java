package org.stellar.base;

import org.stellar.base.xdr.AccountID;
import org.stellar.base.xdr.AssetType;

/**
 * Represents all assets with codes 1-4 characters long.
 */
public class AssetTypeCreditAlphaNum4 extends AssetTypeCreditAlphaNum {

  /**
   * Class constructor
   * @param code
   * @param issuer
   */
  public AssetTypeCreditAlphaNum4(String code, Keypair issuer) {
    super(code, issuer);
    if (code.length() < 1 || code.length() > 4) {
      throw new AssetCodeLengthInvalidException();
    }
  }

  @Override
  org.stellar.base.xdr.Asset toXdr() {
    org.stellar.base.xdr.Asset xdr = new org.stellar.base.xdr.Asset();
    xdr.setDiscriminant(AssetType.ASSET_TYPE_CREDIT_ALPHANUM4);
    org.stellar.base.xdr.Asset.AssetAlphaNum4 credit = new org.stellar.base.xdr.Asset.AssetAlphaNum4();
    credit.setAssetCode(Util.paddedByteArray(mCode, 4));
    AccountID accountID = new AccountID();
    accountID.setAccountID(mIssuer.getXdrPublicKey());
    credit.setIssuer(accountID);
    xdr.setAlphaNum4(credit);
    return xdr;
  }
}

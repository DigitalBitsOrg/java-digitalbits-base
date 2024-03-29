require "bundler"
Bundler.setup()

namespace :xdr do

  # As digitalbits-core adds more .x files, we'll need to update this array
  # Prior to launch, we should be separating our .x files into a separate
  # repo, and should be able to improve this integration.
  HAYASHI_XDR = [
    "src/xdr/Stellar-ledger-entries.x",
    "src/xdr/Stellar-ledger.x",
    "src/xdr/Stellar-overlay.x",
    "src/xdr/Stellar-transaction.x",
    "src/xdr/Stellar-types.x",
    "src/xdr/Stellar-SCP.x",
  ]

  task :update => [:download, :generate]

  task :download do
    require 'octokit'
    require 'base64'

    client = Octokit::Client.new(:netrc => true)

    HAYASHI_XDR.each do |src|
      local_path = "xdr/" + File.basename(src)
      encoded    = client.contents("digitalbits/digitalbits-core", path: src).content
      decoded    = Base64.decode64 encoded

      IO.write(local_path, decoded)
    end
  end

  task :generate do
    require "pathname"
    require "xdrgen"
    require 'fileutils'
    FileUtils.rm_rf "src/main/java/io/digitalbits/base/xdr"

    paths = Pathname.glob("xdr/**/*.x")
    compilation = Xdrgen::Compilation.new(
      paths,
      output_dir: "src/main/java/io/digitalbits/base/xdr",
      namespace:  "io.digitalbits.base.xdr",
      language:   :java
    )
    compilation.compile
  end
end

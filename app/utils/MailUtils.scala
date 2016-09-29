package utils

import play.api.Mode.Mode
import play.api.Mode
import play.api.libs.mailer.{ Email, MailerClient }

/**
 * Created by cdiniz on 29/09/16.
 */
trait MailUtils {
  def sendMail(email: Email, envMode: Mode, mailerClient: MailerClient): Any = {
    if (envMode == Mode.Prod)
      mailerClient.send(email)
    else
      play.api.Logger.debug(email.bodyText.get)
  }
}

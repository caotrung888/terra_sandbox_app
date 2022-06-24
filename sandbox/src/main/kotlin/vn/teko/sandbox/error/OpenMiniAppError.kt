package vn.teko.sandbox.error


/**
 * Created by TrungCS on 20/10/2021.
 * Email: trung.cs@teko.vn
 * Company: Teko
 */
sealed class OpenMiniAppError : Throwable() {
    object EmptyAppCodeError : OpenMiniAppError()
    object NotLoggedIn : OpenMiniAppError()
}
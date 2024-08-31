import SwiftUI
import iosExport

extension iosExport.Screen {
    @ViewBuilder
    func view() -> some View {
        
        switch self {
        case iosExport.Screen.authorization:
            AuthorizationScreen()
        case iosExport.Screen.main:
            MainScreen()
        case iosExport.Screen.splash:
            SplashScreen()
        default:
            AuthorizationScreen()
        }
    }
}

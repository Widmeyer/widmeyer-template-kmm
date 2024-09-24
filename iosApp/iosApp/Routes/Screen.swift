import SwiftUI
import iosExport

extension iosExport.Screen {
    @ViewBuilder
    func view() -> some View {
        
        switch self {
//        case iosExport.Screen.authorization:
//            SplashScreen()AuthorizationScreen()
//        case iosExport.Screen.main:
//            MainScreen()
        case iosExport.Screen.splash:
            ZStack {} // TODO: Change Screen
        default:
            ZStack {} // TODO: Change Screen
        }
    }
}

import SwiftUI


@main
struct iOSApp: App {
    @StateObject private var viewModel = RootViewModelWrapper()
    @State private var navigationPath = NavigationPath()
    @State private var isModalActive = false
    @State private var currentScreen: AnyView = AnyView(SplashScreen())

    static var isModal: Bool = false

    var body: some Scene {
        WindowGroup {
            NavigationStack(path: $navigationPath) {
                ZStack {
                    currentScreen
                        .transition(.customSlide)
                        .animation(.easeInOut, value: UUID())
                }

                .onChange(of: viewModel.screen) { oldState, newState in
                    withAnimation {
                        handleScreenChange(oldScreen: oldState, newScreen: newState)
                    }
                }
                .navigationDestination(for: iosExport.Screen.self) { screen in
                    screen.view()
                        .navigationBarBackButtonHidden(true)
                }
                .onAppear() {
                    viewModel.screen = Screen.splash
                }
            }
        }
    }

    private func handleScreenChange(oldScreen: iosExport.Screen?, newScreen: iosExport.Screen?) {
        if let screen = newScreen {
            if iOSApp.isModal {
                iOSApp.isModal = false

                if let oldScreen = oldScreen {
                    currentScreen = AnyView(
                        screen.view()
                            .sheet(isPresented: .constant(true)) {
                                screen.view()
                            }
                    )
                } else {
                    isModalActive = true

                    currentScreen = AnyView(
                        ZStack {}
                            .sheet(isPresented: $isModalActive) {
                                screen.view()
                                    .onDisappear {
                                        UIApplication.shared.perform(#selector(NSXPCConnection.suspend))

                                    }
                            }
                    )
                }
            } else if viewModel.isClearStack {
                let newView = screen.view()
                currentScreen = AnyView(newView)
                navigationPath = NavigationPath()
            } else {
                navigationPath.append(screen)
            }
        } else {
            if viewModel.areThereOtherOpenScreen() {
                if !navigationPath.isEmpty {
                    navigationPath.removeLast()
                    viewModel.removeLast()
                }
            }
        }
    }
}

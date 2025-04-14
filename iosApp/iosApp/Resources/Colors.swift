import SwiftUI
import iosExport

class Colors {
	var primary: SwiftUI.Color { fatalError("Must override") }
	var secondary: SwiftUI.Color { fatalError("Must override") }
	var transparent: SwiftUI.Color { fatalError("Must override") }
}

class LightColors: Colors {
	override var primary: SwiftUI.Color { MultiplatformResource.colors.primary.getColor() }
	override var secondary: SwiftUI.Color { MultiplatformResource.colors.secondary.getColor() }
	override var transparent: SwiftUI.Color { MultiplatformResource.colors.transparent.getColor() }
}

class DarkColors: Colors {
	override var primary: SwiftUI.Color { MultiplatformResource.colors.primary.getColor() }
	override var secondary: SwiftUI.Color { MultiplatformResource.colors.secondary.getColor() }
	override var transparent: SwiftUI.Color { MultiplatformResource.colors.transparent.getColor() }
}
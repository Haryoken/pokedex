USE [master]
GO
/****** Object:  Database [PokemonDB]    Script Date: 2/22/2018 8:43:37 PM ******/
CREATE DATABASE [PokemonDB]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'PokemonDB', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.HANNSE61793\MSSQL\DATA\PokemonDB.mdf' , SIZE = 3072KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'PokemonDB_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.HANNSE61793\MSSQL\DATA\PokemonDB_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [PokemonDB] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [PokemonDB].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [PokemonDB] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [PokemonDB] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [PokemonDB] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [PokemonDB] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [PokemonDB] SET ARITHABORT OFF 
GO
ALTER DATABASE [PokemonDB] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [PokemonDB] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [PokemonDB] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [PokemonDB] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [PokemonDB] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [PokemonDB] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [PokemonDB] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [PokemonDB] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [PokemonDB] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [PokemonDB] SET  DISABLE_BROKER 
GO
ALTER DATABASE [PokemonDB] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [PokemonDB] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [PokemonDB] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [PokemonDB] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [PokemonDB] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [PokemonDB] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [PokemonDB] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [PokemonDB] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [PokemonDB] SET  MULTI_USER 
GO
ALTER DATABASE [PokemonDB] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [PokemonDB] SET DB_CHAINING OFF 
GO
ALTER DATABASE [PokemonDB] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [PokemonDB] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [PokemonDB] SET DELAYED_DURABILITY = DISABLED 
GO
USE [PokemonDB]
GO
/****** Object:  Table [dbo].[tblAbility]    Script Date: 2/22/2018 8:43:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblAbility](
	[abilityName] [nvarchar](50) NOT NULL,
	[description] [nvarchar](max) NOT NULL,
 CONSTRAINT [PK_tblAbilities] PRIMARY KEY CLUSTERED 
(
	[abilityName] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tblGameGeneration]    Script Date: 2/22/2018 8:43:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblGameGeneration](
	[gameName] [nvarchar](50) NOT NULL,
	[generation] [int] NOT NULL,
	[region] [int] NOT NULL,
	[platform] [nvarchar](50) NOT NULL,
	[releaseDateJAP] [bigint] NULL,
	[releaseDateUS] [bigint] NULL,
	[releaseDateEU] [bigint] NULL,
	[releaseDateAUS] [bigint] NULL,
 CONSTRAINT [PK_tblGameGeneration] PRIMARY KEY CLUSTERED 
(
	[gameName] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tblLocation]    Script Date: 2/22/2018 8:43:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblLocation](
	[id] [int] NOT NULL,
	[location] [nvarchar](max) NULL,
	[regionId] [int] NULL,
 CONSTRAINT [PK_tblLocation] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tblMove]    Script Date: 2/22/2018 8:43:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblMove](
	[name] [nvarchar](50) NOT NULL,
	[type] [nvarchar](15) NULL,
	[category] [nvarchar](15) NULL,
	[power] [int] NULL,
	[accuracy] [int] NULL,
	[pp] [int] NULL,
	[tm] [nvarchar](5) NULL,
	[effect] [nvarchar](max) NULL,
	[probability] [int] NULL,
	[isZMove] [bit] NULL,
	[generationAppearance] [int] NULL,
 CONSTRAINT [PK_tblMove] PRIMARY KEY CLUSTERED 
(
	[name] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tblPokemon]    Script Date: 2/22/2018 8:43:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblPokemon](
	[nationalDexId] [int] NOT NULL,
	[englishName] [nvarchar](20) NOT NULL,
	[japaneseName] [nvarchar](20) NULL,
	[romajiName] [nvarchar](20) NULL,
	[height] [nvarchar](15) NULL,
	[weight] [nvarchar](15) NULL,
	[catchRate] [real] NULL,
	[baseExp] [int] NULL,
	[baseHappiness] [int] NULL,
	[growthRate] [nvarchar](15) NULL,
	[isLegendary] [bit] NULL,
	[pictureURI] [nvarchar](max) NULL,
 CONSTRAINT [PK_tblPokedexId] PRIMARY KEY CLUSTERED 
(
	[nationalDexId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tblPokemonAbilities]    Script Date: 2/22/2018 8:43:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblPokemonAbilities](
	[pokemonId] [int] NOT NULL,
	[abilityName] [nvarchar](50) NOT NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tblPokemonGeneration]    Script Date: 2/22/2018 8:43:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblPokemonGeneration](
	[pokemonId] [int] NOT NULL,
	[appearInGame] [nvarchar](50) NOT NULL,
	[localDexNo] [int] NOT NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tblPokemonLocations]    Script Date: 2/22/2018 8:43:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblPokemonLocations](
	[pokemonId] [int] NULL,
	[pokemonLocation] [int] NULL,
	[condition] [nvarchar](50) NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tblPokemonMoves]    Script Date: 2/22/2018 8:43:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblPokemonMoves](
	[pokemonId] [int] NOT NULL,
	[moveName] [nvarchar](50) NOT NULL,
	[learntByLevelUp] [bit] NULL,
	[learntByTM] [bit] NULL,
	[learntByTutor] [bit] NULL,
	[isEggMove] [bit] NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tblPokemonStats]    Script Date: 2/22/2018 8:43:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblPokemonStats](
	[pokemonId] [int] NOT NULL,
	[baseHP] [int] NULL,
	[attack] [int] NULL,
	[defense] [int] NULL,
	[spAttack] [int] NULL,
	[spDefense] [int] NULL,
	[speed] [int] NULL,
	[minHP] [int] NULL,
	[minAttack] [int] NULL,
	[minDefense] [int] NULL,
	[minSpAttack] [int] NULL,
	[minSpDefense] [int] NULL,
	[minSpeed] [int] NULL,
	[maxHP] [int] NULL,
	[maxAttack] [int] NULL,
	[maxDefense] [int] NULL,
	[maxSpAttack] [int] NULL,
	[maxSpDefense] [int] NULL,
	[maxSpeed] [int] NULL,
 CONSTRAINT [PK_tblStats] PRIMARY KEY CLUSTERED 
(
	[pokemonId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tblPokemonTypes]    Script Date: 2/22/2018 8:43:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblPokemonTypes](
	[pokemonId] [int] NOT NULL,
	[pokemonType] [nvarchar](15) NOT NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tblRegion]    Script Date: 2/22/2018 8:43:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblRegion](
	[id] [int] NOT NULL,
	[regionName] [nvarchar](50) NULL,
	[mapURI] [nvarchar](50) NULL,
 CONSTRAINT [PK_tblRegion] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tblType]    Script Date: 2/22/2018 8:43:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblType](
	[typeLabel] [nvarchar](15) NOT NULL,
	[typeIconURI] [nvarchar](max) NULL,
 CONSTRAINT [PK_tblType_1] PRIMARY KEY CLUSTERED 
(
	[typeLabel] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tblTypeInteraction]    Script Date: 2/22/2018 8:43:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblTypeInteraction](
	[baseType] [nvarchar](15) NOT NULL,
	[affectedType] [nvarchar](15) NOT NULL,
	[effect] [nvarchar](50) NULL,
	[effectMultipler] [real] NULL
) ON [PRIMARY]

GO
ALTER TABLE [dbo].[tblGameGeneration]  WITH CHECK ADD  CONSTRAINT [FK_tblGameGeneration_tblRegion] FOREIGN KEY([region])
REFERENCES [dbo].[tblRegion] ([id])
GO
ALTER TABLE [dbo].[tblGameGeneration] CHECK CONSTRAINT [FK_tblGameGeneration_tblRegion]
GO
ALTER TABLE [dbo].[tblLocation]  WITH CHECK ADD  CONSTRAINT [FK_tblLocation_tblRegion_regionId] FOREIGN KEY([regionId])
REFERENCES [dbo].[tblRegion] ([id])
GO
ALTER TABLE [dbo].[tblLocation] CHECK CONSTRAINT [FK_tblLocation_tblRegion_regionId]
GO
ALTER TABLE [dbo].[tblPokemon]  WITH CHECK ADD  CONSTRAINT [FK_tblPokedexData_tblStats_pokemonId] FOREIGN KEY([nationalDexId])
REFERENCES [dbo].[tblPokemonStats] ([pokemonId])
GO
ALTER TABLE [dbo].[tblPokemon] CHECK CONSTRAINT [FK_tblPokedexData_tblStats_pokemonId]
GO
ALTER TABLE [dbo].[tblPokemonAbilities]  WITH CHECK ADD  CONSTRAINT [FK_tblPokemonAbilities_tblAbility_abilityName] FOREIGN KEY([abilityName])
REFERENCES [dbo].[tblAbility] ([abilityName])
GO
ALTER TABLE [dbo].[tblPokemonAbilities] CHECK CONSTRAINT [FK_tblPokemonAbilities_tblAbility_abilityName]
GO
ALTER TABLE [dbo].[tblPokemonAbilities]  WITH CHECK ADD  CONSTRAINT [FK_tblPokemonAbilities_tblPokedexData_pokemonId] FOREIGN KEY([pokemonId])
REFERENCES [dbo].[tblPokemon] ([nationalDexId])
GO
ALTER TABLE [dbo].[tblPokemonAbilities] CHECK CONSTRAINT [FK_tblPokemonAbilities_tblPokedexData_pokemonId]
GO
ALTER TABLE [dbo].[tblPokemonGeneration]  WITH CHECK ADD  CONSTRAINT [FK_tblPokemonGeneration_tblGameGeneration_appearInGame] FOREIGN KEY([appearInGame])
REFERENCES [dbo].[tblGameGeneration] ([gameName])
GO
ALTER TABLE [dbo].[tblPokemonGeneration] CHECK CONSTRAINT [FK_tblPokemonGeneration_tblGameGeneration_appearInGame]
GO
ALTER TABLE [dbo].[tblPokemonGeneration]  WITH CHECK ADD  CONSTRAINT [FK_tblPokemonGeneration_tblPokedexData_pokemonId] FOREIGN KEY([pokemonId])
REFERENCES [dbo].[tblPokemon] ([nationalDexId])
GO
ALTER TABLE [dbo].[tblPokemonGeneration] CHECK CONSTRAINT [FK_tblPokemonGeneration_tblPokedexData_pokemonId]
GO
ALTER TABLE [dbo].[tblPokemonLocations]  WITH CHECK ADD  CONSTRAINT [FK_tblPokemonLocations_tblLocation_locationId] FOREIGN KEY([pokemonLocation])
REFERENCES [dbo].[tblLocation] ([id])
GO
ALTER TABLE [dbo].[tblPokemonLocations] CHECK CONSTRAINT [FK_tblPokemonLocations_tblLocation_locationId]
GO
ALTER TABLE [dbo].[tblPokemonLocations]  WITH CHECK ADD  CONSTRAINT [FK_tblPokemonLocations_tblPokemon_pokemonId] FOREIGN KEY([pokemonId])
REFERENCES [dbo].[tblPokemon] ([nationalDexId])
GO
ALTER TABLE [dbo].[tblPokemonLocations] CHECK CONSTRAINT [FK_tblPokemonLocations_tblPokemon_pokemonId]
GO
ALTER TABLE [dbo].[tblPokemonMoves]  WITH CHECK ADD  CONSTRAINT [FK_tblPokemonMoves_tblMove_moveName] FOREIGN KEY([moveName])
REFERENCES [dbo].[tblMove] ([name])
GO
ALTER TABLE [dbo].[tblPokemonMoves] CHECK CONSTRAINT [FK_tblPokemonMoves_tblMove_moveName]
GO
ALTER TABLE [dbo].[tblPokemonMoves]  WITH CHECK ADD  CONSTRAINT [FK_tblPokemonMoves_tblPokedexData_pokemonId] FOREIGN KEY([pokemonId])
REFERENCES [dbo].[tblPokemon] ([nationalDexId])
GO
ALTER TABLE [dbo].[tblPokemonMoves] CHECK CONSTRAINT [FK_tblPokemonMoves_tblPokedexData_pokemonId]
GO
ALTER TABLE [dbo].[tblPokemonTypes]  WITH CHECK ADD  CONSTRAINT [FK_tblPokemonTypes_tblPokedexData_pokemonId] FOREIGN KEY([pokemonId])
REFERENCES [dbo].[tblPokemon] ([nationalDexId])
GO
ALTER TABLE [dbo].[tblPokemonTypes] CHECK CONSTRAINT [FK_tblPokemonTypes_tblPokedexData_pokemonId]
GO
ALTER TABLE [dbo].[tblPokemonTypes]  WITH CHECK ADD  CONSTRAINT [FK_tblPokemonTypes_tblType_pokemonType] FOREIGN KEY([pokemonType])
REFERENCES [dbo].[tblType] ([typeLabel])
GO
ALTER TABLE [dbo].[tblPokemonTypes] CHECK CONSTRAINT [FK_tblPokemonTypes_tblType_pokemonType]
GO
ALTER TABLE [dbo].[tblTypeInteraction]  WITH CHECK ADD  CONSTRAINT [FK_tblTypeInteraction_tblType_affected] FOREIGN KEY([affectedType])
REFERENCES [dbo].[tblType] ([typeLabel])
GO
ALTER TABLE [dbo].[tblTypeInteraction] CHECK CONSTRAINT [FK_tblTypeInteraction_tblType_affected]
GO
ALTER TABLE [dbo].[tblTypeInteraction]  WITH CHECK ADD  CONSTRAINT [FK_tblTypeInteraction_tblType_base] FOREIGN KEY([baseType])
REFERENCES [dbo].[tblType] ([typeLabel])
GO
ALTER TABLE [dbo].[tblTypeInteraction] CHECK CONSTRAINT [FK_tblTypeInteraction_tblType_base]
GO
USE [master]
GO
ALTER DATABASE [PokemonDB] SET  READ_WRITE 
GO

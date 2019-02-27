package commonframework.api

interface IRegion {
  val regionType: ERegionType

  fun contains(where: Location): Boolean
  
  fun getRegionSetting(): Map<Pair<IEntityGroup, ERegionAction>, EActionState>
}

enum class ERegionAction {
  COMMAND,
  WALK,
  RUN,
  GET_OUT,
  GET_IN,
  KILL_MOB,
  
  ;
}

@DepencencyInjection
interface IEntityGroup {
  fun contains(e: Entity): Boolean
}

class SingletonEntityGroup(val entity: Entity) : IEntityGroup {
  override fun contains(e: Entity): Boolean {
    return entity == e
  }
}

enum class EActionState {
  ALLOWED,
  DENIED,
  INHERITED,
  
  ;
}

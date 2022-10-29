<template>
  <div>
    <div class="room" v-for="room in rooms" v-bind:key="room.id">
      <div><strong>Number: </strong>{{room.number}}</div>
      <div><strong>Name: </strong>{{room.name}}</div>
      <div><strong>Temperature: </strong>{{room.temperature}}</div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'HelloWorld',
  data() {
    return {
      rooms: []
    }
  },
  mounted() {
    fetch("/api/v1/rooms/")
        .then((response) => response.json())
        .then((data) => {
          this.rooms = data;
        });
  }
}
</script>
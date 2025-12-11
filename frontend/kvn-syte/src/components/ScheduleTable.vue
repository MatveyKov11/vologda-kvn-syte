<template>
    <div class="ui text container">
        <h2 class="ui header">
            <div class="content">
                Расписание игр сезона
            </div>
        </h2>
    </div>
    <table class="ui table">
        <thead><tr>
            <th class="five wide">Название игры</th>
            <th class="five wide">Номер сезона</th>
            <th class="five wide">Дата игры</th>
            <th class="one wide"></th>
        </tr></thead>
        <tbody>
            <tr v-for="game in games" :key="game.id">
                <td>
                    <div class="ui fluid input">
                        <input type="text" name="gameName" v-model="game.gameName">
                    </div>
                </td>
                <td>
                    <div class="ui fluid input">
                        <input type="number" name="seasonNumber" v-model="game.seasonNumber">
                    </div>
                </td>
                <td>
                    <div class="ui fluid input">
                        <input type="date" name="gameDate" v-model="game.gameDate">
                    </div>
                </td>
                <td><i class="minus square icon" @click="deleteRow(game.id)"></i></td>
            </tr>
        </tbody>
    </table>
    <button class="ui button" @click="addRow">
        <i class="plus icon"></i> Добавить игру
    </button>
    <button class="ui button" @click="saveChanges">
        <i class="check icon"></i> Сохранить изменения
    </button>
</template>

<script setup>
import { ref } from 'vue';

const games = ref([
    {
        id: 0,
        gameName: 'Фестиваль',
        seasonNumber: 1,
        gameDate: ''
    },
    {
        id: 1,
        gameName: 'Полуфинал',
        seasonNumber: 1,
        gameDate: ''
    },
    {
        id: 2,
        gameName: 'Финал',
        seasonNumber: 1,
        gameDate: ''
    }
])

function deleteRow(id){
    games.value = games.value.filter(el => el.id != id)
    for(let i = 0; i < games.value.length; i++){
        games.value[i].id = i
    }
}

function addRow(){
    games.value.push({id: games.value.length})
}

function saveChanges(){
    alert('Изменения сохранены!')
    router.push({name: 'Admin Home'})
}
</script>
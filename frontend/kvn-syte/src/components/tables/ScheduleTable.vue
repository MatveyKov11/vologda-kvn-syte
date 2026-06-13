<template>
    <div class="ui text container">
        <h2 class="ui header">
            <div class="content">
                Расписание игр сезона
            </div>
        </h2>
    </div>
    <table class="ui table">
        <thead>
            <tr>
                <th class="center aligned">Название игры</th>
                <th class="center aligned">Расписание</th>
                <th class="one wide"></th>
            </tr>
        </thead>
        <tbody>
            <tr v-for="(game, i) in games" :key="i" @mouseover="game.isVisible = true" @mouseleave="game.isVisible = false">
                <td>
                    <div class="ui fluid input">
                        <input type="text" name="gameName" v-model="game.gameName">
                    </div>
                </td>
                <td>
                    <div class="ui fluid input">
                        <input type="date" name="gameDate" v-model="game.gameDate">
                    </div>
                </td>
                <td>
                    <div class="ui icon red button" @click="deleteRow(i)" v-if="game.isVisible">
                        <i class="x icon"></i>
                    </div>
                </td>
            </tr>
        </tbody>
    </table>
    <button class="ui primary button" @click="addRow">
        <i class="plus icon"></i> Добавить игру
    </button>
    <button class="ui green button" @click="saveChanges">
        <i class="check icon"></i> Сохранить изменения
    </button>
</template>

<script setup>
import router from '@/router';
import { ref } from 'vue';

const games = ref([
    {
        gameName: 'Фестиваль',
        gameDate: '',
        isVisible: false
    },
    {
        gameName: 'Полуфинал',
        gameDate: '',
        isVisible: false
    },
    {
        gameName: 'Финал',
        gameDate: '',
        isVisible: false
    }
])

function deleteRow(r){
    let gamesCopy = []
    for(let i = 0; i < games.value.length; i++){
        if(i != r){
            gamesCopy.push(games.value[i])
        }
    }
    games.value = gamesCopy
}

function addRow(){
    games.value.push({})
}

function saveChanges(){
    alert('Заглушка! Изменения сохранены!')
    router.push({name: 'Admin Home'})
}
</script>
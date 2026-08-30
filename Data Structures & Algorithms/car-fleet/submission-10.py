class Solution:
    def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:

        # Car catches up to another car if it reaches the destination before the car in front of it.

        cars = list(zip(position, speed))
        cars.sort()

        stack = []

        for car in reversed(cars):

            arr = (target - car[0]) / car[1]

            if stack and arr <= stack[-1]:
                continue

            stack.append(arr)

        return len(stack)
